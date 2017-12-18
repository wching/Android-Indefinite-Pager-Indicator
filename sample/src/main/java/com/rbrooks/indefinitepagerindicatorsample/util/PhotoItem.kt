package com.rbrooks.indefinitepagerindicatorsample.util

import android.net.Uri
import com.rbrooks.indefinitepagerindicatorsample.R

enum class PhotoItem(val photoId: Int, val nameId: Int, val locationId: Int, val link: Uri) {

    TANBAR(R.mipmap.tanbar_min, R.string.tanbar, R.string.tanbar_location, Uri.parse("https://earthview.withgoogle.com/tanbar-australia-2381")),
    MAASVLAKTE(R.mipmap.maasvlakte_min, R.string.maasvlakte, R.string.maasvlakte_location, Uri.parse("https://earthview.withgoogle.com/maasvlakte-rotterdam-the-netherlands-2213")),
    BAJA_CALIFORNIA_SUR(R.mipmap.baja_min, R.string.baja, R.string.baja_location, Uri.parse("https://earthview.withgoogle.com/baja-california-sur-mexico-2192")),
    HORMOZGAN(R.mipmap.hormozgan_min, R.string.hormozgan, R.string.hormozgan_location, Uri.parse("https://earthview.withgoogle.com/hormozgan-iran-6510")),
    PUERTO_DE_SANTA_MARIA(R.mipmap.puerto_de_santa_maria_min, R.string.puerto_santa_maria, R.string.puerto_santa_maria_location, Uri.parse("https://earthview.withgoogle.com/el-puerto-de-santa-maria-spain-5770")),
    BELO_HORIZONTE(R.mipmap.belo_horizonte_min, R.string.belo, R.string.belo_location, Uri.parse("https://earthview.withgoogle.com/belo-horizonte-brazil-1741")),
    BEAS(R.mipmap.beas_min, R.string.beas, R.string.beas_location, Uri.parse("https://earthview.withgoogle.com/beas-spain-1607")),
    NAZCA_PROVINCE(R.mipmap.nazca_province_min, R.string.nazca, R.string.nazca_location, Uri.parse("https://earthview.withgoogle.com/nazca-province-peru-1859")),
    TANGANYIKA(R.mipmap.tanganyika_min, R.string.tanganyika, R.string.tanganyika_location, Uri.parse("https://earthview.withgoogle.com/tanganyika-democratic-republic-of-the-congo-2102")),
    CORPEN_AIKE(R.mipmap.corpen_min, R.string.corpen, R.string.corpen_location, Uri.parse("https://earthview.withgoogle.com/corpen-aike-department-argentina-1595")),
    GALLINA(R.mipmap.gallina_min, R.string.gallina, R.string.gallina_location, Uri.parse("https://earthview.withgoogle.com/gallina-united-states-5577")),
    KARAS(R.mipmap.karas_min, R.string.karas, R.string.karas_location, Uri.parse("https://earthview.withgoogle.com/karas-namibia-2346")),
    LEIDSCHENDAM(R.mipmap.leidschendam_min, R.string.leidschendam, R.string.leidschendam_location, Uri.parse("https://earthview.withgoogle.com/leidschendam-the-netherlands-1302")),
    ROBINVALE(R.mipmap.robinvale_min, R.string.robinvale, R.string.robinvale_location, Uri.parse("https://earthview.withgoogle.com/robinvale-irrigation-district-section-c-australia-2372")),
    ABU_DHABI(R.mipmap.abu_dhabi_min, R.string.abu_dhabi, R.string.abu_dhabi_location, Uri.parse("https://earthview.withgoogle.com/abu-dhabi-united-arab-emirates-2021")),
    PLAINFIELD(R.mipmap.plainfield_min, R.string.plainfield, R.string.plainfield_location, Uri.parse("https://earthview.withgoogle.com/plainfield-united-states-1885")),
    ATAR(R.mipmap.atar_min, R.string.atar, R.string.atar_location, Uri.parse("https://earthview.withgoogle.com/atar-mauritania-6360")),
    CAPE_BARREN_ISLAND(R.mipmap.cape_barren_island_min, R.string.cape_barren_island, R.string.cape_barren_island_location, Uri.parse("https://earthview.withgoogle.com/cape-barren-island-australia-5959")),
    CRESWELL(R.mipmap.creswell_min, R.string.creswell, R.string.creswell_location, Uri.parse("https://earthview.withgoogle.com/creswell-australia-2388")),
    BADHAN(R.mipmap.badhan_min, R.string.badhan, R.string.badhan_location, Uri.parse("https://earthview.withgoogle.com/badhan-somalia-6589"))
}