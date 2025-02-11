package no.repairable.backend.repository

import no.repairable.backend.entity.Brand
import no.repairable.backend.entity.Color
import no.repairable.backend.entity.ExcerptColorProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(excerptProjection = ExcerptColorProjection::class)
interface ColorRepository : JpaRepository<Color, Long> {
    fun findByBrandAndName(brand: Brand, name: String): Color?
    fun findByName(name: String): Color?
}
