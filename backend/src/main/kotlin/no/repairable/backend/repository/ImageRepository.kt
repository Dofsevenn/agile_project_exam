package no.repairable.backend.repository

import no.repairable.backend.entity.Image
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ImageRepository : JpaRepository<Image, Long> {

    fun findByImgUrl(url: String): Image?

}