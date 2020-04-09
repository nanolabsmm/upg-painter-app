package com.nanolabs.upgpainter.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nanolabs.upgpainter.R
import kotlinx.android.synthetic.main.activity_personal_register.*
import java.util.*
import kotlin.collections.ArrayList

class PersonalRegisterActivity : AppCompatActivity() {
    var RegionStateNumberAdapter: ArrayAdapter<String>?=null
    var RegionStateAdapter: ArrayAdapter<String>?=null
    var NrcNameListAdapter: ArrayAdapter<String>?=null

    var select_job:String=""
    var select_nrc_region_number=""
    var select_nrc_state =""
    var select_nrc_number = ""

    var selectRegion = ""

    var NrcNameList:ArrayList<String> = arrayListOf("E","N","P","T","Y","S")
    var RegionStateNumberList:ArrayList<String> = arrayListOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14")
    var RegionState1 : ArrayList<String> = arrayListOf("AHGAYA","BAMANA","DAPHAYA","HAPANA","KAMANA","KAMATA","KAPATA","KHABADA","KHALAPHA","KHAPHANA","LAGANA","MAKANA","MAKATA","MAKHABA","MALANA","MAMANA","MANYANA","MASANA","NAMANA", "PANADA","PAWANA","PHAKANA","SABATA","SADANA","SALANA","SAPABA","TANANA","WAMANA","YABAYA")
    var RegionState2 : ArrayList<String> = arrayListOf("BALAKHA","DAMASA","LAKANA","MASANA","PHASANA","PHAYASA","YATANA","YATHANA")
    var RegionState3 : ArrayList<String> = arrayListOf("BAAHNA","BAGALA","BAKALA","BATHASA","KADANA","KAKAYA","KAMAMA","KASAKA","LABANA","LATHANA","LATHANA","MAWATA","PAKANA","PHAAHNA","PHAPANA","SAKALA","THATAKA","THATANA","WALAMA","YAYATHA")
    var RegionState4 : ArrayList<String> = arrayListOf("HAKHANA","HTATALA","KAKHANA","KAPALA","MATANA","MATAPA","PALAWA","PHALANA","SAMANA","TATANA","KAPALA","MATANA","MATAPA","PALAWA","PHALANA","SAMANA","TATANA","TAZANA","YAKHADA","YAZANA")
    var RegionState5 : ArrayList<String> = arrayListOf("AHTANA","AHYATA","BAMANA","BATALA","DAHANA","DAPAYA","HAMALA","HSAMARA","HTAKHANA","HTAPAKHA","KABALA","KALAHTA","KALANA","KALATA","KALAWA","KAMANA","KANANA","KATHANA","KHAOUNA","KHAOUTA","KHAOUTA","KHAPANA","KHATANA","LAHANA","AYANA","MAKANA","MALANA","MAMANA","MAMATA","MAPALA","MATHANA","MAYANA","NAYANA","NGAZANA","PALABA","PALANA","PASANA","PHAPANA","SAKANA","SALAKA","TAMANA","TASANA","WALANA","WATHANA","YABANA","YAMAPA","YAOUNA","YATHAKA")
    var RegionState6 : ArrayList<String> = arrayListOf("BAPANA","HTAWANA","KALAAH","KASANA","KATHANA","KAYAYA","KHAMAKA","LALANA","MAAHNA","MAAHYA","MAMANA","MATANA","NGAYAKA","PAKAMA","PALANA","PALATA","TANATHA","TATHAYA","THAYAKHA","YAPHANA")
    var RegionState7 : ArrayList<String> = arrayListOf("AHPHANA","AHTANA","DAOUNA","HTATAPA","KAKANA","KAPAKA","KATAKHA","KATATA","KAWANA","LAPATA","MADANA","MALANA","MANYANA","NATALA","NYALAPA","PAKHANA","PAKHATA","PAMANA","PANAKA","PATALA","PATANA","PATASA","PATATA","PHAMANA","TANGANA","THAKANA","THANAPA","THASANA","TANGANA","THAKANA","THANAPA","THASANA","THAWATA","WAMANA","YAKANA","YATANA","YATAYA","ZAKANA")
    var RegionState8 : ArrayList<String> = arrayListOf("AHLANA","GAGANA","HTALANA","KAHTANA","KAMANA","KHAMANA","MABANA","MAHTANA","MAKANA","MALANA","MAMANA","MATANA","MATHANA","NAMANA","NGAPHANA","PAKHAKA","PAMANA","PAPHANA","SAKANA","SALANA","SAMANA","SAPAWA","SAPHANA","SATAYA","TATAKA","THAYANA","YAMANA","YANAKHA","MASAKA")
    var RegionState9 : ArrayList<String> = arrayListOf("AHMAYA","AHMAZA","AUTATHA","DAKHATHA","KAMANA","KAPATA","KASANA","KHAAHZA","KHAMASA","LAWANA","MAHAMA", "MAHTALA"," MAKANA","MAKHANA","MALANA","MAMANA","MANAMA","MANATA","MATAYA","MATHANA","MAYAMA","MAYATA","NAHTAKA"," NGATHAYA","NGAZANA","NYAOUNA","PABANA","PABATHA","PAKAKHA","PAMANA","PAOULA","PATHAKA","SAKANA","SAKATA","TAKANA","TAKATA","TATAOU","TATHANA","THAPAKA","THASANA","WATANA","YAKANA","YAMATHA","ZABATHA","ZAYATHA")
    var RegionState10 : ArrayList<String> = arrayListOf("BALANA","KAHTANA","KAKHAMA","KAMAYA","KHASANA","KHAZANA","LAMANA","MADANA","MALAMA","PAMANA","KAMAYA","KHASANA","KHAZANA","LAMANA","MADANA","MALAMA","PAMANA","THAHTANA","THAPHAYA","YAMANA")
    var RegionState11 : ArrayList<String> = arrayListOf("AHMANA","BATHATA","GAMANA","KAPHANA","KATALA","KATANA","MAAHNA","MAAHTA","MAOUNA","MAPANA","MAPATA","MATANA","PANAKA","PANATA","PATANA","SATANA","TAKANA","TAPAWA","THATANA","YABANA","YATHATA")
    var RegionState12 : ArrayList<String> = arrayListOf("AHLANA","AHSANA","BAHANA","BATAHTA","DAGAMA","DAGANA","DAGASA","DAGATA","DAGAYA","DALANA","DAPANA","HTATAPA","KAKAKA","KAKHAKA","KAMANA","KAMATA","KAMAYA","KATANA","KATATA","KHAYANA","LAKANA","LAMANA","LAMATA","LATHANA","LATHAYA","MABANA","MAGADA","MAGATA","MAYAKA","OUKAMA","OUKATA","PABATA","PAZATA","SAKAKHA","SAKANA","SAKHANA","TAKANA","TAMANA","TATAHTA","TATANA","THAGAKA","THAKATA","THAKHANA","THALANA","YAKANA","YAPATHA")
    var RegionState13 : ArrayList<String> = arrayListOf("AHPANA","AHTANA","AHTHAYA","HAHANA","HAMANA","HAPANA","HAPATA","KAHANA","KAKANA","KAKHANA","KALADA","KALAHTA","KALANA","KALATA","KAMANA","KATALA","KATANA","KATATA","KATHANA","KHALANA","KHAYAHA","LAKANA","LAKHANA","LAKHATA","LALANA","AYANA","MABANA","MAHAYA","MAHTANA","MAHTATA","MAKANA","MAKATA","MAKHANA","MAKHATA","MALANA","MALATA","MAMAHTA","MAMANA","MAMATA","MANANA","MANATA","MANGANA","MAPANA","MAPANA","MAPATA","MAPHANA","MAPHATA","MARATA","MASANA","MASATA","MASATA","MATANA","MATATA","MAYAHTA","MAYANA","MAYANA","MAYANA","MAYATA","NAHSANA","NAKHANA","NAKHATA","NAMATA","NAPHANA","NASANA","NATAYA","NYAYANA","PALANA","PALATA","PAPAKA","PASANA","PASATA","PATAYA","PAWANA","PAYANA","PHAKHANA","SASANA","TAKANA","TAKHALA","TALANA","TAMANYA","TATANA","TAYANA","THANANA","THAPANA","YANGANA","MANYANA","MASANA")
    var RegionState14 : ArrayList<String> = arrayListOf("AHGAPA","AHMANA","AHMATA","BAKALA","DADAYA","DANAPHA","HAKAKA","HATHATA","KAKAHTA","KAKANA","KAKHANA","KALANA","KAPANA","LAMANA","LAPATA","MAAHNA","MAAHPA","MAMAKA", "MAMANA", "NGAPATA","NGASANA","NGATHAKHA","NGAYAKA","NYATANA","PASALA","PATANA","PATHAAH","PATHANA","PATHAYA","PHAPANA","PATANA","PATHAAH","PATHANA","PATHAYA","PHAPANA","THAPANA","WAKHAMA","YAKANA","YATHAYA","ZALANA")
    var defaultChooseName = ArrayList(Arrays.asList("---မြို့/မြို့နယ်ရွေးရန်---"))

    var regionList: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
            "---တိုင်းဒေသကြီးရွေးရန်---",
            "မကွေးတိုင်း",
            "ကချင်ပြည်နယ်",
            "ကယားပြည်နယ်",
            "ကရင်ပြည်နယ်",
            "ချင်းပြည်နယ်",
            "စစ်ကိုင်းတိုင်း",
            "တနင်္သာရီတိုင်း",
            "ပဲခူးတိုင်း",
            "မန္တလေးတိုင်း",
            "မွန်ပြည်နယ်",
            "ရခိုင်ပြည်နယ်",
            "ရန်ကုန်တိုင်း",
            "ရှမ်းပြည်နယ်",
            "ဧရာဝတီတိုင်း",
            "နေပြည်တော်"
        )
    )
    var MAGWAY: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "---မြို့/မြို့နယ်ရွေးရန်---",
            "ဂန့်ဂေါ",
            "‌ ဆော ",
            " ထီးလင်း",
            " ဆိပ်ဖြူ",
            "ပခုက္ကူ ",
            " ပေါက်",
            "မြိုင် ",
            " ရေစကြို",
            " ချောက်",
            "တောင်တွင်းကြီး ",
            "နတ်မောက် ",
            " မြို့သစ်",
            "ရေနံချောင်း ",
            " ငဖဲမြို့နယ်",
            " စလင်း",
            " စေတုတ္တရာမြို့နယ်",
            " ပွင့်ဖြူ",
            " မင်းဘူး",
            " ကံမ မြို့နယ်",
            " ဆင်ပေါင်ဝဲ",
            " မင်းတုန်း",
            "မင်းလှ ",
            "သရက် ",
            " အောင်လံ ",
            "အခြား"

        )
    )
    var MANDALAY: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            " ကျောက်ဆည်",
            " စဉ့်ကိုင်",
            " တံတားဦး",
            " မြစ်သား",
            " ကျောက်ပန်းတောင်း",
            " ညောင်ဦး",
            " စဉ့်ကူး",
            " ပြင်ဦးလွင်",
            " မိုးကုတ်",
            " မတ္တရာ",
            " သပိတ်ကျင်း",
            " ချမ်းမြသာစည်",
            " ချမ်းအေးသာဇံ",
            " ပြညိကြီးတံခွန်",
            " မဟာအောင်မြေ",
            "‌ အောင်မြေသာဇံ",
            " ပုသိမ်ကြီး",
            " အမရပူရ",
            " မလှိုင်",
            " မိထ္တိလာ",
            " ဝမ်းတွင်း",
            " သာစည်",
            " ငါန်းစွန်",
            " တောင်သာ",
            " နွားထိုးကြီး",
            "  မြင်းခြံ",
            "  ပျော်ဘွယ်",
            " ရမည်းသင်း",
            " မန္တလေး",
            " အခြား"
        )
    )
    var NAYPYIDAW: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ဇမ္ဗူသီရိ",
            "ဒက္ခိသီရိ",
            "ပျဥ်းမနား",
            "လယ်‌ဝေး",
            "‌ဇေယျာသီရိ",
            "တပ်ကုန်း",
            "ပုဗ္ဗသီရိ",
            "ဥတ္တသီရိ",
            "နေပြည်တော်",
            "အခြား"
        )
    )
    var KAYAH: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ဖားဆောင်း",
            "ဘော်လခဲ",
            "မယ်စဲ",
            "ဒီးမော့ဆို",
            "ဖရူဆို",
            "ရှားတော",
            "လှိုင်ကော်",
            "အခြား"
        )
    )
    var SHAN: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကျောက်မဲ",
            " နမ္မတူ",
            " နမ့်ဆန်",
            "နောင်ချို ",
            "မန်တုံ ",
            "သီပေါ ",
            "ကျိုင်းတုံ ",
            " မိုင်းခတ်",
            " မိုင်းယန်း",
            " မိုင်းလား",
            "မိုင်းပျဉ်း ",
            "တာချီလိတ် ",
            "မိုင်းဖြတ် ",
            " မိုင်းယောင်း",
            " ကလော",
            "ဆီဆိုင် ",
            " ညောင်ရွှေ",
            "တောင်ကြီး ",
            " ပင်းတယ",
            "ပင်လောင်း ",
            "ဖယ်ခုံ ",
            " ရွာငံ",
            " ရပ်စောက်",
            " ဟိုပုံး",
            "ကွတ်ခိုင် ",
            " နမ့်ခမ်း",
            "မူဆယ် ",
            " မဘိမ်း",
            " နားဖန်း",
            " ပန်ဆန်း",
            "မက်မန်း ",
            " မိုင်းဆက်",
            " မိုင်းတုံ",
            " ကွမ်းလုံ",
            "တန့်ယန်း ",
            " မိုင်းရယ်",
            " လားရှိုး",
            "သိန္နီ ",
            " မိုးနဲ",
            " မိုင်းပန်",
            "မောက်မယ် ",
            "လင်းခေး ",
            " ကုန်းကြမ်း",
            "လောက်ကိုင် ",
            " ကျေးသီး",
            " ကွန်ဟိန်း",
            " နမ့်စန်",
            " မိုင်းရှုး",
            " လဲချား",
            " လွိုင်လင်",
            "ပန်ဝိုင် ",
            " မိုင်းမော",
            "ဟိုပန် ",
            " အခြား"
        )
    )
    var AYEYARWADY: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကန်ကြီး‌ထောင့်",
            " ကျောင်းကုန်း",
            " ကျုံပျော်",
            " ငပုတော",
            " ပုသိမါ",
            " ရေကြည်",
            " သာပေါင်း",
            " ကျိုက်လတ်",
            "ဒေးဒရဲ ",
            "ဖျာပုံ ",
            " ဘိုကလေး",
            " ညောင်တုန်း",
            " ဓနုဖြူ",
            " ပန်းတနော်",
            " မြောင်းမြ",
            " ဝါးခယ်မ",
            " မအူပင်",
            " အိမ်မဲ",
            " မော်လမြိုင်ကျွန်း",
            "လပွတ္တာ ",
            " ကြံခင်း",
            "ဇလွန် ",
            " မြန်အောင်",
            "လေးမျက်နှာ ",
            " ဟသာ်တ",
            " အဂ်ပူ",
            "အခြား ",
            " ချောင်းသာ",
            " ငွေဆောင်"
        )
    )
    var BAGO: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကျောက်ကြီး",
            "‌ တောင်ငူ",
            "ထန်းတပင်",
            "ဖြူး",
            "‌‌အုတ်တွင်း",
            "ကဝ",
            "‌ ကျောက်တံခါး",
            "‌ ညောင်လေးပင်",
            "ဒိုက်ဦး",
            "ပဲခူး",
            "‌ရွှေကျင်",
            "‌ဝေါ",
            "သနပ်ပင်",
            "‌ ပေါက်ခေါင်း",
            "‌‌ ပေါင်းတည်",
            "ပန်း‌‌တောင်း",
            "ပြည်",
            "‌ရွှေတောင်",
            "သဲကုန်း",
            "ကြို့ပင်ကောက်",
            "ဇီးကုန်း",
            "နတ်တလင်း",
            "မိုးညို",
            "မင်းလှ",
            "လက်ပံတန်း",
            "သာယာဝတီ",
            "အုတ်ဖို",
            "အခြား"
        )
    )
    var YANGON: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "တိုက်ကြီး ",
            "ထန်းတပင် ",
            " မဂ်လာဒုံ",
            " မှော်ဘီ",
            " ရွှေပြည်သာ",
            "လှိုင်သာယာ ",
            "လှည်းကူး ",
            " အင်းစိန်",
            " တာမွေ",
            "တောင်ဥက္ကလာ ",
            "ဒဂုံမြို့သစ် (ဆိပ်ကမ်း) ",
            " ဒဂုံမြို့သစ် (တောင်ပိုင်း)",
            " ဒဂုံမြို့သစ် (အရှေ့ပိုင်း)",
            " ဒဂုံမြို့သစ် (မြောက်ပိုင်း)",
            " ဒေါပုံ",
            "ပုဇွန်တောင် ",
            " ဗိုလ်တစ်ထောင်",
            "မဂ်လာတောင်ညွှန့် ",
            " မြောက်ဥက္ကလာပ",
            " ရန်ကင်း",
            "သာကေတ ",
            " သဃ်န်းကျွန်း",
            " ကိုကိုးကျွန်း",
            "ကော့မူး ",
            "ကျောက်တန်း ",
            " ကွမ်းခြံကုန်း",
            "ခရမ်း ",
            " ဆိပ်ကြီးခ‌နောင်တို",
            " တွံတေး",
            "ဒလ ",
            " သန်လျင်",
            "သုံးခွ ",
            "ကမာရွက် ",
            " ကျောက်တံတား",
            "ကြည့်မြင်တိုင် ",
            " စမ်းချောင်း",
            "ဆိပ်ကမ်း ",
            " ဒဂုံ",
            " ပန်းပဲတန်း",
            " ဗဟန်း",
            "မရမ်းကုန်း ",
            " လသာ",
            " လမ်းမတော်",
            " အလုံ",
            "လှိုင်မြို့နယ် ",
            "အခြား "

        )
    )
    var KACHIN: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ခေါင်လန်းဖူး",
            "ဆွမ်ပရာဘွမ်",
            " ‌နောင်မွန်း",
            "ပူတာအို",
            "မချမ်း‌‌ဘော",
            "ဗန်း‌‌မော်",
            "မံစီ",
            "မိုး‌မောက်",
            "‌ ရွှေကူ",
            "ဖားကန့်",
            "မိုး‌ကောင်း",
            "မိုးညှင်း",
            "ချီ‌ဖွေ",
            "‌ ဆော့‌လော်",
            "တနိုင်း",
            " မြစ်ကြီးနား",
            " ဝိုင်းမော်",
            "အင်ဂျန်းယန်",
            "အခြား"

        )
    )
    var SAGAING: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကလေး",
            "က‌လေးဝ",
            "မင်းကင်း",
            "ကသာ",
            "အင်းတော်",
            "ထီးချိုင့်",
            "ပင်လည်ကူး",
            "ဗန်းမောက်",
            "ဝန်းသို",
            "အင်းတော်",
            "ကန့်ဘလူ",
            "ကျွန်းလှ",
            "တန့်ဆည်",
            "ရေဦး",
            "ခန္တီး",
            "နန်းယွန်း",
            "လဟယ်",
            "လေရှီး",
            "ဟုမ္မလင်း",
            "စစ်ကိုင်း",
            "မြင်းမူ",
            "မြောင်",
            "တမူး",
            "ဖောင်းပြင်",
            "မော်လိုက်",
            "ချောင်းဦး",
            "ဘုတလင်",
            "မုံရွာ",
            "အရာတော်",
            "ကနီ",
            "ဆားလင်းကြီး",
            "ပုလဲ",
            "ယင်းမာပင်",
            "ခင်ဦး",
            "ဒီပဲယင်း",
            "ရွှေဘို",
            "ဝက်လက်",
            "အခြား"

        )
    )
    var KAYIN: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကော့ကရိတ်",
            "ကြာအင်းဆိပ်ကြီး",
            "ဖာပွန်မြို့",
            "ဘားအံ",
            "လှိုင်းဘွဲ့",
            "သံတောင်ကြီး",
            "မြဝတီ",
            "အခြား"
        )
    )
    var MON: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            " ကျိုက်မရော",
            "ချောင်းဆုံ ",
            " မုဒုံ",
            "မော်လမြိုင် ",
            " ရေး",
            " သံဖြူဇရပ်",
            " ကျိုက်ထို",
            " ပေါင်",
            "ဘီးလင်း ",
            " သထုံ",
            "မုတ္တမမြို့ ",
            " အခြား"

        )
    )
    var TANINTHARYI: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကော့သောင်း",
            "ဘုတ်ပြင်",
            "ထားဝယ်",
            "‌ရေဖြူ",
            "‌လောင်းလုံး",
            "သရက်ချောင်း",
            "ကျွန်းစု",
            "တနင်္သာရီ",
            "ပု‌လော",
            "မြိတ်",
            "အခြား"
        )
    )
    var CHIN: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "တီးတိန်",
            "တွန်းဇန်",
            "ဖလမ်း",
            "ကန်ပက်လက်",
            "ပလက်ဝ",
            "မတူပီ",
            "မင်းတပ်",
            "ထန်တလန်",
            "ဟားခါး",
            "အခြား"
        )
    )
    var RAKHINE: ArrayList<String> = ArrayList<String>(
        Arrays.asList(
             "--မြို့/မြို့နယ်ရွေးရန်---",
            "ကျောက်ဖြူ ",
            "မာန်အောင် ",
            "ရမ်းဗြဲ ",
            "အမ်း ",
            " စစ်တွေ",
            " ပေါက်တော",
            " ပုဏ္ဍားကျွန်း",
            " ရသေ့တောင်",
            " ဘူးသီးတောင်",
            " မောင်းတော",
            "ကျောက်တော် ",
            " မင်းပြား",
            " မြေပုံ",
            "မြောက်ဦး ",
            "ဂွ",
            " တောင်ကုတ်",
            " သံတွဲ",
            "အခြား "
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_register)

        supportActionBar!!.hide()
        btnContinue.setOnClickListener {
            startActivity(Intent(this, MainBottomNavigationActivity::class.java))
            finish()
        }

        RegionStateNumberAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,RegionStateNumberList)
        RegionStateNumberAdapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinnerRegion.adapter = RegionStateNumberAdapter


//        NrcNameListAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,NrcNameList)
//        NrcNameListAdapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        NrcNameListAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,NrcNameList)
        NrcNameListAdapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinnerNumber.adapter = NrcNameListAdapter

        spinnerRegion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                select_nrc_region_number = parent?.getItemAtPosition(position).toString()
                if(select_nrc_region_number=="1"){
                    selectNRC(RegionState1)
                }else  if(select_nrc_region_number=="2"){
                    selectNRC(RegionState2)
                }else  if(select_nrc_region_number=="3"){
                    selectNRC(RegionState3)
                }else  if(select_nrc_region_number=="4"){
                    selectNRC(RegionState4)
                }else  if(select_nrc_region_number=="5"){
                    selectNRC(RegionState5)
                }else  if(select_nrc_region_number=="6"){
                    selectNRC(RegionState6)
                }else  if(select_nrc_region_number=="7"){
                    selectNRC(RegionState7)
                }else  if(select_nrc_region_number=="8"){
                    selectNRC(RegionState8)
                }else  if(select_nrc_region_number=="9"){
                    selectNRC(RegionState9)
                }else  if(select_nrc_region_number=="10"){
                    selectNRC(RegionState10)
                }else  if(select_nrc_region_number=="11"){
                    selectNRC(RegionState11)
                }else  if(select_nrc_region_number=="12"){
                    selectNRC(RegionState12)
                }else  if(select_nrc_region_number=="13"){
                    selectNRC(RegionState13)
                }else  if(select_nrc_region_number=="14"){
                    selectNRC(RegionState14)
                }
            }

        }

        spinnerState.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                select_nrc_state = parent?.getItemAtPosition(position).toString()

            }

        }

        spinnerNumber.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                select_nrc_number = parent?.getItemAtPosition(position).toString()

            }

        }


        var spRegionAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,regionList)
        spRegionAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spRegion.adapter = spRegionAdapter

        spRegion.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                selectRegion = parent?.getItemAtPosition(position).toString()

                   if(selectRegion.equals("---တိုင်းဒေသကြီးရွေးရန်---")){
                       selectTownship(defaultChooseName);
                       //spCity.isEnabled = false

                   }

                   if (selectRegion=="မကွေးတိုင်း") {
                       selectTownship(MAGWAY);
                       spCity.isEnabled = true
                   }else if(selectRegion == "မန္တလေးတိုင်း"){
                       selectTownship(MANDALAY);
                       spCity.isEnabled = true
                   }else if(selectRegion=="နေပြည်တော်"){
                       selectTownship(NAYPYIDAW);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ကယားပြည်နယ်"){
                       selectTownship(KAYAH);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ရှမ်းပြည်နယ်"){
                       selectTownship(SHAN);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ဧရာဝတီတိုင်း"){
                       selectTownship(AYEYARWADY);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ပဲခူးတိုင်း"){
                       selectTownship(BAGO);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ရန်ကုန်တိုင်း"){
                       selectTownship(YANGON);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ကချင်ပြည်နယ်"){
                       selectTownship(KACHIN);
                       spCity.isEnabled = true

                   }else if(selectRegion=="စစ်ကိုင်းတိုင်း"){
                       selectTownship(SAGAING);
                       spCity.isEnabled = true

                   }else if(selectRegion=="ကရင်ပြည်နယ်"){
                       selectTownship(KAYIN);
                       spCity.isEnabled = true
                   }else if(selectRegion=="မွန်ပြည်နယ်"){
                       selectTownship(MON);
                       spCity.isEnabled = true

                   }else if(selectRegion=="တနင်္သာရီတိုင်း"){
                       selectTownship(TANINTHARYI);
                       spCity.isEnabled = true

                   }else if(selectRegion=="ချင်းပြည်နယ်"){
                       selectTownship(CHIN);
                       spCity.isEnabled = true
                   }else if(selectRegion=="ရခိုင်ပြည်နယ်"){
                       selectTownship(RAKHINE);
                       spCity.isEnabled = true
                   }
               }

        }

        spCity.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
              if(selectRegion==""){
                  Toast.makeText(applicationContext,"တိုင်းဒေသကြီးကို  အရင်ရွေးရန်",Toast.LENGTH_LONG).show()
              }
            }

        }

    }

    fun selectNRC(list:ArrayList<String>){
        var jobAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,list)
        jobAdapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinnerState.adapter = jobAdapter
    }

    fun selectTownship(list1:ArrayList<String>){
      var regionAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,list1)
        regionAdapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spCity.adapter = regionAdapter
    }
}
