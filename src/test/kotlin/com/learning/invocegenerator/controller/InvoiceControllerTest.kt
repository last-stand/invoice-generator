package com.learning.invocegenerator.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.learning.invocegenerator.models.Invoice
import com.learning.invocegenerator.models.InvoiceItem
import com.learning.invocegenerator.repository.InvoiceRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.BDDMockito.given
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class InvoiceControllerTest {

    lateinit var mockMvc: MockMvc

    @InjectMocks
    lateinit var invoiceController: InvoiceController

    @Mock
    lateinit var invoiceRepository: InvoiceRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(invoiceController).build()
    }

    @Test
    fun testGetAllInvoicesWillReturnCollectionOfInvoiceObject() {
        val invoiceItem: Set<InvoiceItem> = emptySet()
        val invoice = Invoice(1, "You", invoiceItem, "23-05-2018")
        val invoiceList: List<Invoice> = listOf(invoice)
        given(invoiceRepository.findAll()).willReturn(invoiceList)

        mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo { result ->
                    val invoiceJson = result.getResponse().getContentAsString()
                    val mapper = jacksonObjectMapper()
                    val resultInvoiceList: List<Invoice> = mapper.readValue(invoiceJson)
                    assertEquals(invoiceList, resultInvoiceList)
                }
        BDDMockito.verify(invoiceRepository, BDDMockito.times(1)).findAll()
        Mockito.verifyNoMoreInteractions(invoiceRepository)
    }

    @Test
    fun testGetInvoiceByIdWillReturnAnInvoiceObject() {
        val invoiceItem: Set<InvoiceItem> = emptySet()
        val invoice = Invoice(1, "You", invoiceItem, "12-09-2018")
        var optionalInvoice = Optional.of(invoice)
        given(invoiceRepository.findById(1)).willReturn(optionalInvoice)

        mockMvc.perform(MockMvcRequestBuilders.get("/api/invoice/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo { result ->
                    val invoiceJson = result.getResponse().getContentAsString()
                    val mapper = jacksonObjectMapper()
                    val resultInvoice: Invoice = mapper.readValue(invoiceJson)
                    assertEquals(invoice, resultInvoice)
                }
        BDDMockito.verify(invoiceRepository, BDDMockito.times(1)).findById(1)
        Mockito.verifyNoMoreInteractions(invoiceRepository)
    }
}