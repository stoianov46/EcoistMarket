package com.ecoist.market.data.mapper

import com.ecoist.market.data.model.Category
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.data.roomdb.CategoryModel

object CategoryMapper {

    fun map(categories: List<CategoryResponse>): List<Category> {
        return categories
            .filter {
                // Exclude non-active categories
                it.isPublic == 1
            }
            .map { categoryResponse -> mapSingle(categoryResponse) }
    }

    fun mapModel(categories: List<CategoryResponse>): List<CategoryModel> {
        return categories
            .filter {
                // Exclude non-active categories
                it.isPublic == 1
            }
            .map { category -> mapToRoom(category) }
    }

    private fun mapToRoom(categoryResponse: CategoryResponse): CategoryModel {

        fun makeUrlForImage(): String {
            var str = "https://ecoist.com.ua/gallery/category/"
            when (categoryResponse.id.toInt()) {
                2 -> return str + "alternativnaja-energia/image_13161_190_190.gif"
                4 -> return str + "energosberezhenie/image_13159_190_190.gif"
                18 -> return str + "electrotransport/image_13157_190_190.gif"
                25 -> return str + "komplektujushie/image_13160_190_190.gif"
                35 -> return str + "ecotovari/image_13162_190_190.gif"
                74 -> return str + "zelenoe-stroitelstvo/image_13158_190_190.gif"
                80 -> return str + "ecoprodukti/image_13163_190_190.gif"
                34-> return str + "avtonomnie-electrostancii/image_9733_190_190.gif"
                15 -> return str + "solnechnie-kollektori/image_859_190_190.gif"
                68 -> return str + "biotoplivo/image_6719_190_190.gif"
            }

            /*when (categoryResponse.alias) {
                 "solnechnie-batarei" -> return str + "solnechnie-batarei/image_9734_190_190.gif"
                  "setevie-electrostancii" -> return str + "setevie-electrostancii/image_11004_190_190.gif"
                 "avtonomnie-electrostancii" -> return str + "avtonomnie-electrostancii/image_9733_190_190.gif"
                 "solnechnie-zarjadnie" -> return str + "solnechnie-batarei/image_9734_190_190.gif"
                 "solnechnie-kollektori" -> return str + "solnechnie-kollektori/image_859_190_190.gif"
                 "vetrogeneratori" -> return str + "vetrogeneratori/image_9735_190_190.gif"
                 "gidroelectrostancii" -> return str + "gidroelectrostancii/image_9737_190_190.gif"
                 "gazogenerator" -> return str + "gazogenerator/image_6282_190_190.gif"
                 "biotoplivo" -> return str + "biotoplivo/image_6719_190_190.gif"
                 "gazovie-generatori" -> return str + "gazovie-generatori/image_9736_190_190.gif"
                 "drova" -> return str + "drova/image_6699_190_190.gif"
                 "electromobili" ->return str + "electromobili/image_720_190_190.gif"
                 "electrocar" ->return str + "electrocar/image_3826_190_190.gif"
                 "electrovelosipedi" ->return str + "electrovelosipedi/image_1124_190_190.gif"
                 "electroskuteri" ->return str +"electroskuteri/image_451_190_190.gif"
                 "electrotraktor" -> return str + "electrotraktor/image_7411_190_190.gif"
                 "electrosamokati" -> return str +"electrosamokati/image_527_190_190.gif"
                 "electromotocikli" ->return str + "electromotocikli/image_1234_190_190.gif"
                 "electrolodki" -> return str + "electrolodki/image_453_190_190.gif"
                 "velosipedi" -> return str + "velosipedi/image_1123_190_190.gif"
                 "detskie-electromobili" ->return str + "detskie-electromobili/image_1233_190_190.gif"
                 "detskie-elektrokvadrocikli" ->return str + "detskie-elektrokvadrocikli/image_3389_190_190.gif"
                 "detskie-velosipedi" ->return str + "detskie-velosipedi/image_3323_190_190.gif"
                 "detskie-elektromotocikli" ->return str +"detskie-elektromotocikli/image_3388_190_190.gif"
                 "gibridnie-avtomobili" ->return str + "gibridnie-avtomobili/image_842_190_190.gif"
                 "girobordy" -> return str + "girobordy/image_10292_190_190.gif"
                 "monokolesa" ->return str +"monokolesa/image_10293_190_190.gif"
                 "segvei" -> return str + "segvei/image_10323_190_190.gif"
                 "elektrovelonabory" -> return str + "elektrovelonabory/image_12400_190_190.gif"
                 "samokaty" ->return str + "samokaty/image_12402_190_190.gif"
                 "kvadrokoptery" -> return str + "kvadrokoptery/image_12399_190_190.gif"
                 "elektro-invalidnye-konsoli" -> return str + "elektro-invalidnye-konsoli/image_12860_190_190.gif"
                 "sazhenci" -> return str +"sazhenci/image_12865_190_190.gif"
                 "umnij-dom" ->return str + "umnij-dom/image_5766_190_190.gif"
                 "svetodiodnie-lampi" -> return str + "svetodiodnie-lampi/image_682_190_190.gif"
                 "svetodiodnie-projektori" -> return str + "svetodiodnie-projektori/image_5808_190_190.gif"
                 "svetodiodnie-svetilniki" ->return str +"svetodiodnie-svetilniki/image_5809_190_190.gif"
                 "ekovata" ->return str + "ekovata/image_5765_190_190.gif"
                 "perlit" -> return str + "perlit/image_5182_190_190.gif"
                 "vermikulit" -> return str + "vermikulit/image_5759_190_190.gif"
                 "machti-vetrogeneratorov" -> return str +"machti-vetrogeneratorov/image_564_190_190.gif"
                 "energosberegajushie-okna" ->return str + "energosberegajushie-okna/image_862_190_190.gif"
                 "vintovie-svai" -> return str + "vintovie-svai/image_5184_190_190.gif"
                 "mebel-is-dereva" -> return str + "mebel-is-dereva/image_6704_190_190.gif"
                 "mramor" ->return str + "mramor/image_6713_190_190.gif"
                 "granit" -> return str + "granit/image_6714_190_190.gif"
                 "svetodiodnie-lustri" -> return str +"svetodiodnie-lustri/image_7476_190_190.gif"
                 "ecodom" -> return str + "ecodom/image_4720_190_190.gif"
                 "ecodizajn" ->return str + "ecodizajn/image_6818_190_190.gif"
                 "teplij-pol" -> return str + "teplij-pol/image_9286_190_190.gif"
                 "tverdotoplivnye-kotly-i-pechi" -> return str + "tverdotoplivnye-kotly-i-pechi/image_5813_190_190.gif"
                 "teplovie-nasosi" ->return str + "teplovie-nasosi/image_5810_190_190.gif"
                 "energosberegajushie-elektroobogrevateli" ->return str +"energosberegajushie-elektroobogrevateli/image_9377_190_190.gif"
                 "elektrodnyye-kotly" -> return str + "elektrodnyye-kotly/image_5795_190_190.gif"
                 "Mikatermicheskie-obogrevateli" -> return str + "Mikatermicheskie-obogrevateli/image_5758_190_190.gif"
                 "drovjanye-pechi" ->return str + "drovjanye-pechi/image_5817_190_190.gif"
                 "protochnyye-vodonagrevateli" -> return str + "protochnyye-vodonagrevateli/image_6785_190_190.gif"
                 "Induktsionnyye-kotly" ->return str + "Induktsionnyye-kotly/image_5791_190_190.gif"
                 "teploakkumulyatory" ->return str +"teploakkumulyatory/image_5788_190_190.gif"
                 "infrakrasnie-obogrevateli" ->return str + "infrakrasnie-obogrevateli/image_1979_190_190.gif"
                 "Gazoviy-obogrevatel" ->return str + "Gazoviy-obogrevatel/image_5756_190_190.gif"
                 "electricheskie-teploventiliatori" ->return str +"electricheskie-teploventiliatori/image_5793_190_190.gif"
                 "elektrokotli" ->return str +  "elektrokotli/image_6401_190_190.gif"
                 "keramicheskie-paneli" ->return str +  "keramicheskie-paneli/image_11062_190_190.gif"
             }*/
            return str
        }
        return CategoryModel(
            id = categoryResponse.id,
            idParent = categoryResponse.idParent,
            name = categoryResponse.name,
            alias = categoryResponse.alias,
            compared = categoryResponse.compared,
            deleted = categoryResponse.deleted,
            showBanner = categoryResponse.showBanner,
            categoryOrder = categoryResponse.categoryOrder,
            product_list_cols = categoryResponse.product_list_cols,
            short_desc_on_product = categoryResponse.short_desc_on_product,
            show_mods = categoryResponse.show_mods,
            isPublic = categoryResponse.isPublic,
            show_links = categoryResponse.show_links,
            image = makeUrlForImage()
        )
    }

    private fun mapSingle(categoryResponse: CategoryResponse): Category {

        fun makeUrlForImage(): String {
            var str = "https://ecoist.com.ua/gallery/category/"
            when (categoryResponse.id.toInt()) {
                2 -> return str + "alternativnaja-energia/image_13161_190_190.gif"
                4 -> return str + "energosberezhenie/image_13159_190_190.gif"
                18 -> return str + "electrotransport/image_13157_190_190.gif"
                25 -> return str + "komplektujushie/image_13160_190_190.gif"
                35 -> return str + "ecotovari/image_13162_190_190.gif"
                74 -> return str + "zelenoe-stroitelstvo/image_13158_190_190.gif"
                80 -> return str + "ecoprodukti/image_13163_190_190.gif"
            }
            when (categoryResponse.alias) {
                "solnechnie-batarei" -> return str + "solnechnie-batarei/image_9734_190_190.gif"
            }
            return str
        }
        return Category(
            id = categoryResponse.id,
            idParent = categoryResponse.idParent,
            name = categoryResponse.name,
            alias = categoryResponse.alias,
            compared = categoryResponse.compared,
            deleted = categoryResponse.deleted,
            showBanner = categoryResponse.showBanner,
            categoryOrder = categoryResponse.categoryOrder,
            product_list_cols = categoryResponse.product_list_cols,
            short_desc_on_product = categoryResponse.short_desc_on_product,
            show_mods = categoryResponse.show_mods,
            isPublic = categoryResponse.isPublic,
            show_links = categoryResponse.show_links,
            image = makeUrlForImage()
        )
    }
}
