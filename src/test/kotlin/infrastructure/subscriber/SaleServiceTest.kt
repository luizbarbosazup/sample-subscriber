package infrastructure.subscriber

import br.com.itau.warriors.sample.core.port.SaleServicePort
import br.com.itau.warriors.sample.infrastructure.model.Event
import br.com.itau.warriors.sample.infrastructure.model.SaleEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleInformation
import br.com.itau.warriors.sample.infrastructure.subscribe.SaleService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SaleServiceTest:AnnotationSpec() {

    val service = mockk< SaleServicePort>(relaxed = true)
    val saleService = SaleService(service = service)

    lateinit var saleInformation: SaleInformation

    @BeforeEach
    fun setUp(){
        saleInformation = SaleInformation(
            eventEntity = Event.SAVE_SALE,
            saleEntity = SaleEntity(
                productid = UUID.randomUUID(),
                qty = 10.0
            )
        )
    }

    @Test
    fun `should be void `(){
        every { service.saveSale(any()) } answers { Unit}
        val result = saleService.receive(saleInformation =saleInformation )
        result shouldBe Unit
    }


}