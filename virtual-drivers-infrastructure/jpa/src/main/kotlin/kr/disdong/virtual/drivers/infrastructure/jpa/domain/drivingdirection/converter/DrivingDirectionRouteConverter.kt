package kr.disdong.virtual.drivers.infrastructure.jpa.domain.drivingdirection.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Converter
class DrivingDirectionRouteConverter : AttributeConverter<List<Pair<Int, Int>>, String> {
    override fun convertToDatabaseColumn(attribute: List<Pair<Int, Int>>): String {
        return Json.encodeToString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<Pair<Int, Int>> {
        return dbData?.let { Json.decodeFromString<List<Pair<Int, Int>>>(it) } ?: emptyList()
    }
}
