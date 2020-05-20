package no.repairable.backend.entity

import org.springframework.data.rest.core.config.Projection
import javax.persistence.*

@Entity
@Table(name = "Size")
data class Size (
        @Id
        @GeneratedValue
        @Column(name = "id")
        var id: Long? = null,

        //@NotNull
        @Column(name = "size")
        var size: String = "",

        @ManyToMany(mappedBy = "sizes")
        var products: List<Product>? = null
)

@Projection(
        name = "excerpt",
        types = [Brand::class]
)
interface ExcerptSizeProjection {

        fun getId(): Long
        fun getSize(): String

}