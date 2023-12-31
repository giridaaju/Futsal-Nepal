package com.example.futsalnepalapp.files.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.futsalnepalapp.files.util.Futsal
import com.example.futsalnepalapp.R
import java.util.concurrent.Flow

@Dao
interface FutsalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(futsal: Futsal)

    @Query("SELECT * FROM futsals")
    fun getAllFutsals(): LiveData<List<Futsal>>

    @Query("SELECT name FROM futsals")
    fun getFutsalNames(): LiveData<List<String>>

    @Delete
    suspend fun delete(futsal: Futsal)

    @Query("SELECT * FROM futsals WHERE name LIKE :searchQuery OR address LIKE :searchQuery OR tole LIKE :searchQuery OR city LIKE :searchQuery")
    fun searchFutsals(searchQuery: String): LiveData<List<Futsal>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun initialUpsert() {
        upsert(Futsal(1, "A-One Futsal and Football Academy", "near Indrayani bridge", "Manamaiju" , "Kathmandu", "5:30am-9:30pm", "9808670663", "https://goo.gl/maps/iRZcHve3kabnvfkr7", R.drawable.gmaps_ss_aone_futsal))
        upsert(Futsal(2, "Adarsa Futsal", " " , "Dhungeadda", "Kathmandu" , "6am-8pm", " ", "https://goo.gl/maps/7XtoMhDpXvkr7nnr6", 0))
        upsert(Futsal(3, "Baijanti Futsal", " ", "Dibyeshwori", "Bhaktapur", "6:30am-8pm", "9801057185, 9810197322", "https://goo.gl/maps/eypucMKTm9QHwJQ89", 0))
        upsert(Futsal(4, "Balami Sports Center", " ", "Sitapaila", "Kathmandu", "5am-9pm", "9841896323", "https://goo.gl/maps/pCkVGGFihmVokMN38", 0))
        upsert(Futsal(5, "Balchhi Dhurbe Futsal", "Kharibot", "Banasthali", "Kathmandu", "6am-9pm", "01-5139293", "https://goo.gl/maps/c1EYzDdnPuGyhdxT7", 0))
        upsert(Futsal(6, "Balkot Boyz Futsal", " ", "Balkot", "Bhaktapur", "5am-8pm", "01-5211173", "https://goo.gl/maps/BQGcoRryh8Zd4aiaA", 0))
        upsert(Futsal(7, "Ballpark Sports Events & Academy", " ", "Imadol", "Mahalaxmi", "6am-8pm", "01-5203767", "https://goo.gl/maps/trHw5nxScU3TLKjC8", 0))
        upsert(Futsal(8, "Banepa Futsal", " ", "Ugratara Janagal", "Banepa", "8am-7pm", "9851162932", "https://goo.gl/maps/UQEmhAP1RwGTuLGN8", 0))
        upsert(Futsal(9, "Baneshwor Recreation Center", "Sahabhagita Marg", "Baneshwor", "Kathmandu", "6am-9pm", "01-4105028", "https://goo.gl/maps/8YsbPHevRbnEuS1G9", 0))
        upsert(Futsal(10, "Best Futsal Imadol", "Shiva Gate", "Imadol", "Mahalaxmi", "6am-9pm", "9843041041", "https://goo.gl/maps/yyN4ahBoEWHYW9a3A", 0))
        upsert(Futsal(11, "BG Brothers Futsal", " ", "Pepsicola", "Bhaktapur", "6am-8pm", "9843505050", "https://goo.gl/maps/pYQz555kVvAD68nQ8", 0))
        upsert(Futsal(12, "Bhadrakali Futsal and Recreation Center", " ", "Budhanilkantha", "Kathmandu", "6am-8pm", "9840432104", "https://goo.gl/maps/rWRfAy5HmvvQhx4m6", 0))
        upsert(Futsal(13, "Bhaktapur Futsal", "Araniko Highway", "Suryabinayak", "Bhaktapur", "6am-9pm", "01-6610404", "https://goo.gl/maps/WAmUNCG6K76GuUi5A", 0))
        upsert(Futsal(14, "Bhotebahal Futsal", " ", "Bhotebahal", "Kathmandu", "6am-9pm","9823325282", "https://goo.gl/maps/8HGozS3nNUL1ggbL8", 0))
        upsert(Futsal(15, "Binayak Futsal Centre", "Binayak Chowk", "Changathali", "Mahalaxmi", "6am-9pm", "9810014215, 9843089081", "https://goo.gl/maps/9kLADbktkTH7BpKs8", 0))
        upsert(Futsal(16, "Binayak Sports Complex", "Chibahal-Dholahiti Marg", "Dholahiti", "Lalitpur", "6am-8pm", "9851138783", "https://goo.gl/maps/sGBTXr8conbTW6aEA", 0))
        upsert(Futsal(17, "Bishal Futsal", " ", "Samakhusi", "Kathmandu", "7am-8pm", " ", "https://goo.gl/maps/vAcx45FTzaBAis3d7", 0))
        upsert(Futsal(18, "Bode Futsal and Training Centre", "Madhyapur Thimi-8", "Bode", "Bhaktapur", "6am-9pm", "9813401628, 9849725838, 9851219988", "https://goo.gl/maps/PYLZnBKYJqNmSeeNA", 0))
        upsert(Futsal(19, "Brother's Futsal and Snooker House", " ", "Gokarneshwor", "Kathmandu", "6am-9pm", "9849041400", "https://goo.gl/maps/wLrpJSMDbmpdSVSz7", 0))
        upsert(Futsal(20, "Buddhanagar Futsal", " ", "Buddhanagar", "Kathmandu", "6am-8pm", "01-4792002", "https://g.page/Buddhanagarfutsal?share", 0))
        upsert(Futsal(21,"Busy Futsal"," ", "Kuleshwor", "Kathmandu", "6am-8pm", "9851038695", "https://goo.gl/maps/bQ5EafsU7ZFf53ov5", 0))
        upsert(Futsal(22, "Chaitya Futsal", " ", "Soaltee Mode", "Kathmandu", "7am-7pm", "9849719060","https://goo.gl/maps/3pDfcycq3VdAqqja8", 0))
        upsert(Futsal(23, "Champions Futsal", " ", "Imadol", "Lalitpur", "6am-9pm", "01-5203998", "https://goo.gl/maps/HEi7B4oNVL41Zmwt5", 0))
        upsert(Futsal(24, "Chandragiri Futsal", "Aakash Tole", "Chandragiri", "Kathmandu", "6am-9pm", "9841354837, 9861962309", "https://goo.gl/maps/C1vdGHT9emPuCXcVA", 0))
        upsert(Futsal(25, "Chapagaun Futsal", " ", "Chapagaun", "Lalitpur", "6am-8pm", "9843326033", "https://goo.gl/maps/pyTHqscp1iFtVnrW6", 0))
        upsert(Futsal(26, "Chaur Recreational Center", "Neuro Hospital", "Bansbari" ,"Kathmandu", "6am-9pm", "9851156443, 01-4377515", "https://g.page/chaurfutsal?share", 0))
        upsert(Futsal(27, "Countryside Recreation Centre", "Suryabinayak-1", "Sirutar", "Bhaktapur", "6am-8pm", "9860976204", "https://goo.gl/maps/Ku1hatrwUm3tGEQf6", 0))
        upsert(Futsal(28, "Creative Futsal", "Devnagar","Shankhamul", "Lalitpur", "6am-9pm", "9801913886, 9818688783", "https://goo.gl/maps/4gyZbmvFE9AeAxb86", 0 ))
        upsert(Futsal(29, "Crystal Futsal", " ", "Rabi Bhawan","Kathmandu", " ", " ", "https://goo.gl/maps/sShztia7q1d5RxjK7", 0))
        upsert(Futsal(30, "Cupon Sports Center", " ", "Kapan", "Kathmandu" ,"6:30am-8pm", "01-4164392", "https://g.page/cscnepal?share", 0))
        upsert(Futsal(31, "Dhanyentari Futsal", "Dhanawantari Marg", "Hadigaun", "Kathmandu", "6am-9pm", "01-4009635", "https://goo.gl/maps/XdBid5smYrPUT4kv5", 0))
        upsert(Futsal(32, "Dhobighat Futsal", " ", "Dhobighat", "Lalitpur", " ", "9818331610, 98086063487", "https://goo.gl/maps/Wr3anoGEdyLDMQkc8", 0))
        upsert(Futsal(33, "Dhuku Sports Hub", "Shittal Marg", "Maharajgunj", "Kathmandu", "6am-9pm", "01-4535832", "https://goo.gl/maps/mjSfHqmRfFYUrdM6A", 0))
        upsert(Futsal(34, "DIG Futsal", "Balambu", "Chandragiri", "Kathmandu","Open 24 hours", "9866038268", "https://goo.gl/maps/b7nEfubQCXKJFHMfA", 0))
        upsert(Futsal(35, "Easy Futsal", " ", "Pepsicola", "Bhaktapur", "6am-8pm", "01-4990648, 9863790290", "https://goo.gl/maps/RmEKUySYQXhPcFgaA", 0))
        upsert(Futsal(36, "Elite Futsal", " ", "Kirtipur", "Kathmandu", "7am-8pm", "9840737438", "https://goo.gl/maps/JB4Gmw4qgWRac2uo7", 0))
        upsert(Futsal(37, "Elite Sports Training Centre", " ", "Nakkhudol", "Lalitpur", "6am-8pm", "9813201976", "https://goo.gl/maps/4HEGnYKTw4mXC8fn7", 0))
        upsert(Futsal(38, "Field Futsal", " ", "Sanepa", "Lalitpur", "7am-9pm", "01-5528361", "https://goo.gl/maps/EBsHuut2frTon1aUA", 0))
        upsert(Futsal(39, "Five Five Soccer Center", "Mangal Galli", "Gairigaun", "Kathmandu", "6am-7pm", "01-4112251", "https://goo.gl/maps/ym9SttdbfUcRWdaf8", 0))
        upsert(Futsal(40,"Friends Star Futsal", " ",  "Tokha", "Kathmandu", "Open 24 hours", "9808134744", "https://goo.gl/maps/fHM8N4Us7vxv2qt77", 0 ))
        upsert(Futsal(41, "Futsal Arena Boudha", " ", "Boudha", "Kathmandu", "6am-9pm", "9801070700", "https://goo.gl/maps/Y6jSB26oCMNUB4wF9", 0))
        upsert(Futsal(42, "Futsal Court Funpark", "Bhrikuti Mandap Park", "Pradarshani Marg", "Kathmandu", "10am-6pm", "9803641222", "https://goo.gl/maps/ATbgSNhYTtoqz6U69", 0))
        upsert(Futsal( 43, "Futsal Park", "Buddhachowk", "Thulo Bharyang", "Kathmandu", "6am-8pm", "9860700348, 9808007019", "https://goo.gl/maps/un8DHViKYkDNRSAUA", 0))
        upsert(Futsal(44, "Futsal Village", "Satdobato-Tikabhairab Rd", "Nakhipot", "Lalitpur", "Temporarily Closed", "9808390866", "https://goo.gl/maps/Ts1hefutoTGWnDVf7", 0))
        upsert(Futsal(45, "G4 Futsal & Badminton", " ", "Hiledol", "Kathmandu", "6am-8pm", "9803259660", "https://goo.gl/maps/NccVLMbaGrAqVvbaA", 0))
        upsert(Futsal(46, "Gajurmukhee Futsal", " ", "Nagarjun", "Kathmandu", "6am-8pm", "9869392979", "https://goo.gl/maps/ScSa6HpXEBxF9kXZ7", 0))
        upsert (Futsal(47, "Goalpost Futsal", "Nayabazar", "Bhaisepati", "Lalitpur", "6am-8pm", "01-5590590", "https://goo.gl/maps/gYTTucYopiE1VJSY6", 0))
        upsert(Futsal(48, "Godawari Futsal", " ", "Taukhel", "Lalitpur", "6am-8pm", "9841746795", "https://goo.gl/maps/Ck8T41MC29AJ5tLDA", 0))
        upsert(Futsal( 49, "Gokarneshwor Futsal tatha Fitness Club", " ", "Gokarneshwor", "Kathmandu", "5am-9pm", "9851009498, 01-5223087", "https://goo.gl/maps/4hM69VzsPRxGf7ev8", 0))
        upsert(Futsal(50, "Grace Futsal", "near GEMS school", "Dhapakhel", "Lalitpur", "6am-8pm", "9801237744", "https://goo.gl/maps/6NKKheq1CLGiVs3N8", 0))
        upsert(Futsal( 51, "Grande Sports Center", "Nainadol", "Tokha", "Kathmandu", "6am-8pm", "01-5159290", "https://goo.gl/maps/uuBpyveyZ9eWsBah8", 0))
        upsert(Futsal( 52, "Green Futsal", "Tinchuli", "Boudha", "Kathmandu", "6am-7pm", "9813134139", "https://goo.gl/maps/nSQ7ErXDQ6WbxdgL7", 0))
        upsert(Futsal(53, "Green Wish Fitness Club & Futsal Center"," ", "Kapan", "Kathmandu", "7am-8pm", "01-4822420", "https://goo.gl/maps/BKHG9LDLmDZ4ZmbbA", 0))
        upsert(Futsal(54, "Hamro Futsal", "Saraswatinagar", "Chabahil", "Kathmandu", " ", "01-4822000", "https://goo.gl/maps/VL38bZiE8eJFu5RY7", 0))
        upsert(Futsal(55, "Hamro Futsal", "Pipal Marg ", "Bansbari", "Kathmandu", "6am-8pm", " ", "https://goo.gl/maps/a37YXF5cg3Nk15EN7", 0))
        upsert(Futsal(56, "Hamro Futsal", "Chapali", "Budhanilkantha","Kathmandu", "5am-9pm", "9861582968", "https://goo.gl/maps/tsavvkoAJ8FYXSHR7", 0))
        upsert(Futsal(57, "Hamro Futsal", " ", "Syuchatar", "Kathmandu", "6am-8pm", "9851034401", "https://goo.gl/maps/Ps7wWUmCYB2RyTeH8", 0))
        upsert(Futsal(58, "Harisiddhi Futsal", " ", "Harisiddhi", "Lalitpur", "6am-9pm", "01-5251068", "https://goo.gl/maps/tsVvWfuZ66sGQqnQ6", 0))
        upsert(Futsal(59, "Hattiban Futsal", " ", "Hattiban", "Lalitpur", "6am-9pm", "01-5251490", "https://goo.gl/maps/k2yq8tPzWU3toYxq6", 0))
        upsert(Futsal(60, "Healthy Futsal", "Itabu-8", "Suryabinayak", "Bhaktapur", "6am-10pm", "9861613399", "https://goo.gl/maps/DJtEKPBAdsAaf9g49", 0))
        upsert(Futsal(61, "Highway Futsal", " ", "Jorpati", "Kathmandu", "6am-8pm", "9808675143", "https://goo.gl/maps/HskuJcqstVyCRMbj9", 0))
        upsert(Futsal(62, "Imadol Futsal", " ", "Imadol", "Mahalaxmi", "5am-8pm", "9841271350", "https://goo.gl/maps/AZUCbXa5sXcEkwxc8", 0))
        upsert(Futsal(63, "Imperial Futsal", "Sagbari", "Kausaltar", "Bhaktapur", "6am-7pm", "01-6636833", "https://goo.gl/maps/WMAfqXK38PK4LXAm7", 0))
        upsert(Futsal(64, "Jadibuti Futsal", " ", "Jadibuti", "Kathmandu", "\"Sat: 9am-9pm\n" + "Sun+: 5am-9pm\n" + "Fri: 1pm-9pm\" ", "9828722447", "https://goo.gl/maps/c29yihVjc1FG4zy16", 0))
        upsert(Futsal(65, "Jorpati Futsal", "Near East Pole School, Narayantar", "Jorpati", "Kathmandu", "Open 24 hours", "9808100362, 9808696669, 9843156162", "https://goo.gl/maps/M263e2He8XaPzdFD7", 0))
        upsert(Futsal(66, "Kaasthamandap Futsal Academy", " ", "Mandikhatar", "Kathmandu", "6am-8pm", "9828758114", "https://goo.gl/maps/qCgYN16JeA9rdLGKA", 0))
        upsert(Futsal(67, "Kantipur Futsal and Training Center", " ", "Mandikhatar", "Kathmandu", "6am-8pm", "9851313355", "https://goo.gl/maps/csq8FdAyo81M31He7", 0))
        upsert(Futsal(68, "Kathmandu Futsal", " ", "Bagdole", "Lalitpur", "6am-10pm", "9802115981", "https://goo.gl/maps/jrNcXjUdJv7jhtndA", 0))
        upsert(Futsal(69, "Khel Maidan Recreational Centre", " ", "Changunarayan", "Bhaktapur", "7am-9pm", "9849423385", "https://goo.gl/maps/QqUV5jKf6meeEhUg8", 0))
        upsert(Futsal(70, "Khwopa Futsal", " ", "Libali-2", "Bhaktapur", "6am-9pm", "01-5122051", "https://goo.gl/maps/YKsthHXAjQiWpj6k8", 0))
        upsert(Futsal(71, "Khwopa Futsal and Training Center", "Sundarbasti", "Suryabinayak", "Bhaktapur", "6am-9pm", "01-5177177", "https://goo.gl/maps/cC5CZye92zdscZPQ7", 0))
        upsert(Futsal(72, "Kick Futsal", "UN Park Road", "Shankhamul", "Lalitpur", "6am-8pm", "9808121351", "https://goo.gl/maps/1FwiZ8JfFUJFfr4a7", 0))
        upsert(Futsal(73, "Kirtipur Futsal", " ", "Kirtipur", "Kathmandu", "6am-9pm", "9818149835", "https://goo.gl/maps/pimCyLazd1j8WUMq5", 0))
        upsert(Futsal(74, "Krinagar Futsal", "Tyanglaphat", "Kirtipur", "Kathmandu", "6am-8pm", "9851120195", "https://goo.gl/maps/sdrT4WWA9KYcQz2Y6", 0))
        upsert(Futsal( 75, "Kumari Futsal", "Paknajol Marg", "Thamel", "Kathmandu", "6am-10pm", "01-4243709", "https://goo.gl/maps/eEm7tNqpX3bJgQvu7", 0))
        upsert(Futsal(76, "Lakhur Futsal", "Harisiddhi-Damaitar Rd", "Harisiddhi", "Lalitpur", "6am-9pm", "9823374788", "https://goo.gl/maps/oqnAhpxDB9MkKjJJ9", 0))
        upsert(Futsal(77, "Lalitpur 5A Side Futsal", "Triveni Marg", "Sanepa", "Lalitpur", "6am-8pm", "01-5535453", "https://goo.gl/maps/5Z5eqKzKRmzysfw4A", 0))
        upsert(Futsal(78, "Le Himalaya Futsal Wellness Center", "Sri Nagar", "Boudha", "Kathmandu", "5am-8pm", "01-4813226, 9803437908", "https://goo.gl/maps/GFmQq9ucLuCt22uN9", 0))
        upsert(Futsal(79, "Legend Futsal", "Thatikot", "Tikathali", "Mahalaxmi", "6am-9pm", "9844565741", "https://goo.gl/maps/Vz96CEgkdDGRWqg86", 0))
        upsert(Futsal(80, "Lumbini Futsal Academy", "Chuchepati", "Boudha", "Kathmandu", "7am-8pm", "9819741866", "https://goo.gl/maps/pxgKyiynNo4nvHBD7", 0))
        upsert(Futsal(81, "Maa Baglamukhi Futsal", " ", "Dathulan", "Lalitpur", "6am-8pm", "01-5260611", "https://goo.gl/maps/Vr5yr2XBp4Qn7gSp9", 0))
        upsert(Futsal(82, "Mahalaxmi Futsal", " ", "Imadol", "Mahalaxmi", " ", "9823845380", "https://goo.gl/maps/B1iYTKBeuWbEARnY8", 0))
        upsert(Futsal(83, "Maidan Futsal", " ", "Battisputali", "Kathmandu", "Temporarily Closed", "01-4497642", "https://goo.gl/maps/fVCQB6JuNS41bBzF8", 0))
        upsert(Futsal(84, "Manakamana Futsal", "Dakshindhoka", "Gokarneshwor", "Kathmandu", "6am-8pm", "9808403232", "https://goo.gl/maps/Rkj5rEMF3JXP4F9J9", 0))
        upsert(Futsal(85, "Manang Marsyangdi Futsal", " ", "Samakhusi", "Kathmandu", "6am-8pm", "01-6200126", "https://goo.gl/maps/y6b1hgQX8Yxta71NA", 0))
        upsert(Futsal(86, "Mate's Futsal", "back of Soaltee Hotel", "Tahachal", "Kathmandu", "6am-9pm", "01-5237714", "https://goo.gl/maps/yFReeWcvorr1KKfE7", 0))
        upsert(Futsal(87, "Matshya Recreation Center", "Machhegaun", "Chandragiri", "Kathmandu", "6am-9pm", "9818149835", "https://goo.gl/maps/rZBCQ8bnw7kvu6UK9", 0))
        upsert(Futsal(88, "Monastery Futsal", " ", "Basantanagar", "Kathmandu", "5am-8pm", "9808491431", "https://goo.gl/maps/aTCGorGZXXUpECH26", 0))
        upsert(Futsal(89, "Mulpani Futsal Training Center", " ", "Khaharey", "Kageshwori Manohara", "6am-8pm", "9813165088", "https://goo.gl/maps/K7xyTD7q7Vz9TNow7", 0))
        upsert(Futsal(90, "Nagarjun Futsal", " ", "Raniban", "Kathmandu", " ", "9863523510", "https://goo.gl/maps/urM3PJ1T44gxGTeR7", 0))
        upsert(Futsal(91, "Narkate Futsal", " ", "Yeti Aawash", "Mahalaxmi", "6am-9pm", "9841194711", "https://goo.gl/maps/pTnvsNUssSsyaiEC6", 0))
        upsert(Futsal(92, "National Sports and Swimming Center", " ", "Chyasal", "Lalitpur", "6am-8pm", "01-5534470", "https://goo.gl/maps/cpEPtybpwa3biSyEA", 0))
        upsert(Futsal(93, "Nayapati Futsal Arena", "Bhumthali", "Gokarneshwor", "Kathmandu", "6am-8pm", "01-4800176", "https://goo.gl/maps/F37aZnRM1Cv7RMt38", 0))
        upsert(Futsal(94, "Nepa Futsal", " ", "Chamati", "Kathmandu", "Open 24 hours", "9843199318", "https://goo.gl/maps/iaP9bz4919YRx3AQA", 0))
        upsert(Futsal(95, "Nirvana Leisure Centre", " ", "Dhapakhel", "Lalitpur", "6am-6pm", "9851166261", "https://goo.gl/maps/wjnzT9d6sBNFYYAM8", 0))
        upsert(Futsal(96, "North Point Futsal", "Madhyapur Thimi-8", "Bode", "Bhaktapur", "6am-8pm", " ", "https://goo.gl/maps/gdNJ2i8FKEbg1tmo7", 0))
        upsert(Futsal(97, "One Tree Hill Futsal", " ", "Bhaisepati", "Lalitpur", "6am-9pm", "9851173355", "https://goo.gl/maps/8bGqtNutq5asg9Bg8", 0))
        upsert(Futsal(98, "Pasa Futsal and Food Pasal", " ", "Boudha", "Kathmandu", "6am-8pm", "9815545619", "https://goo.gl/maps/8UG67S15psj6zG4b8", 0))
        upsert(Futsal(99, "Pasikot Futsal", "Pasikot", "Budhanilkantha", "Kathmandu", "Open 24 hours", "9823047542", "https://goo.gl/maps/y6pzUNJSjuazoWGq7", 0))
        upsert(Futsal(100, "Pheonix Futsal and Swimming Pool", " ", "Manamaiju", "Kathmandu", "6am-8:15pm", "9803954921", "https://goo.gl/maps/fHZxDWWQeVCJWiFk6", 0))
        upsert(Futsal(101, "Phutung Futsal", "Phutung", "Tarkeshwor", "Kathmandu", "6am-8pm", "9851031161, 9869042514", "https://goo.gl/maps/3vPgv6mKRM8p77iX8", 0))
        upsert(Futsal(102, "Players Futsal", "Khadkagaun", "Kalanki", "Kathmandu", "6am-8pm", "9840022376", "https://goo.gl/maps/uB2vcCVkHYiajnFF7", 0))
        upsert(Futsal(103, "Premier Futsal", "Baniyatar Rd", "Tokha", "Kathmandu", "6am-8pm", "01-4365122", "https://goo.gl/maps/zsaonigj9NjKxkY88", 0))
        upsert(Futsal(104, "Prime Futsal Gyaneshwor", " ", "Gyaneshwor", "Kathmandu", "6am-8pm", "01-4446461, 9860306492", "https://goo.gl/maps/J1yfDDXNV3dSUiaw9", 0))
        upsert(Futsal(105, "Prismatic Futsal and Recreation Center", "behind Gyanodaya School", "Sanepa", "Lalitpur", "7am-9:15pm", "01-5906629, 01-5521587,9841934471", "https://goo.gl/maps/TqUaTBVFzCFrr77T9", 0))
        upsert(Futsal(106, "Promotional Futsal", "Madhyapur Thimi-3", "Gatthaghar", "Bhaktapur", "\"Sat: 6am-10pm\n" + "Sun+: 6am-8pm\" ", "01-6212821" ,"https://goo.gl/maps/hhYfgJSPwLrQiRAu7", 0))
        upsert(Futsal(107, "Raftaar Futsal", "Saraswatinagar", "Chabahil" ,"Kathmandu", "\"Sun: 5am-12am\n" + "Sat+: 5am-9pm\" ", "9843151509", "https://goo.gl/maps/3BvjAyHsed24WrPi6", 0))
        upsert(Futsal(108, "Rave Futsal Center", " ", "Mandikhatar", "Kathmandu", "7am-8pm", "01-4374343", "https://goo.gl/maps/kFrdiDLqPBbi1TQe7", 0))
        upsert(Futsal(109, "River Field Futsal", "Khusibu" ,"Nayabazar", "Kathmandu", "6am-8pm", "01-4361095", "https://goo.gl/maps/SHSmBDoXjUTjt26o9", 0))
        upsert(Futsal(110, "RL Futsal", " ", "Chapagaun", "Lalitpur", "6am-9pm", "9851136913", "https://goo.gl/maps/KoHHZFGz32T3YVmY8", 0))
        upsert(Futsal(111, "Royal Futsal", " ", "University Road", "Dhulikhel", " ", "9843184531", "https://goo.gl/maps/vtZqX6cYbGFUov2R8", 0))
        upsert(Futsal(112, "Royal Futsal", "Thapagaun", "Anamnagar", "Kathmandu", "7am-9pm", "01-5244436", "https://goo.gl/maps/PFP2TJmA7uVNxfqD6", 0))
        upsert(Futsal(113, "Rumble Futsal", "Peepalbasti", "Gokarneshwor", "Kathmandu", "Open 24 Hours", "9803451468" ,"https://goo.gl/maps/CSrD6c5FJCJfFGDs8", 0))
        upsert(Futsal(114, "S. Glory Futsal", " ", "Suryabinayak", "Bhaktapur", "6am-8pm", "9840252869, 9813098728", "https://goo.gl/maps/v6ugZkXapdaHHr6B6", 0))
        upsert(Futsal(115, "Samakhusi Futsal", " ", "Samakhusi", "Kathmandu", "6am-8pm", "01-4963834", "https://goo.gl/maps/aszrwLXVHyJMPe5C8", 0))
        upsert(Futsal(116, "Sevenways Futsal & Cricket Training Center", "behind ANFA complex" ,"Satdobato", "Lalitpur", " ", "9818274893", "https://goo.gl/maps/STZ2G3c9F5Na1iMt6", 0))
        upsert(Futsal(117, "Shankhamul Futsal", " ", "Shankhamul", "Kathmandu", "\"Sat: 6am-9pm\n" + "M-F: 5am-10pm\n" + "Sun: 6am-9:30pm\" ", "01-4792088", "https://goo.gl/maps/scp3rrbiagDyhA1D6", 0))
        upsert(Futsal(118, "Shantinagar Futsal", " ", "Shantinagar", "Kathmandu", "6am-8pm", "9851188182, 01-4108159", "https://goo.gl/maps/ofYy3eyMiUd8KEDS7", 0))
        upsert(Futsal(119, "Sherpa Futsal Center", "Mahankal", "Boudha", "Kathmandu", "6am-8pm", "9860866662", "https://goo.gl/maps/E2DFMkQaPD3XBXCa7", 0))
        upsert(Futsal(120, "Shooters Futsal", " ", "Suryabinayak", "Bhaktapur", "7am-8pm", "01-6619708", "https://goo.gl/maps/zRgFpT43xmWzuA1VA", 0))
        upsert(Futsal(121, "Shrestha Swimming Pool and Futsal", " ", "Kapan", "Kathmandu", "7am-7pm", "01-4164365", "https://goo.gl/maps/8NazBr8tvJDuPoxY6", 0))
        upsert(Futsal(122, "Sinamangal Mini Futsal", "Tara Hall Chowk", "Sinamangal", "Kathmandu", "8am-7pm", "9861030224", "https://goo.gl/maps/pMTJ6TMqB82S2Md17", 0))
        upsert(Futsal(123, "SR Futsal", " ", "-", "Dhulikhel", "5am-9:30pm", "9851204310", "https://goo.gl/maps/QR3m45zq2doj6ZPk7", 0))
        upsert(Futsal(124, "Star Futsal", " ", "Pabitranagar", "Kathmandu", "6am-8pm", "9846438561", "https://goo.gl/maps/F7yua1rwfVffxrJPA", 0))
        upsert(Futsal(125, "Sunrise S.A.S Futsal", "Ring Road" ,"Sanepa" ,"Lalitpur", "6am-8pm", "9860782591", "https://goo.gl/maps/7zUz5mqxQEy5XpXY7", 0))
        upsert(Futsal(126, "Surya Futsal", " ", "Dhumbarahi", "Kathmandu", "5am-7pm", "01-4371660, 9810183247", "https://goo.gl/maps/ywQRXLL2DdMGs4nA7", 0))
        upsert(Futsal(127, "SV Futsal", "Jana Ekta Marg", "Shankhamul", "Lalitpur", "6am-9pm", "9842536020", "https://goo.gl/maps/B2Mgh7DGe7xgjigs6", 0))
        upsert(Futsal(128, "Swoyambhu Recreation Center", " ", "Swoyambhu", "Kathmandu", "7am-9pm", "01-5247239", "https://goo.gl/maps/mFVPQfFt6vzrXbNx7", 0))
        upsert(Futsal(129, "Tahachal Physical Fitness Center", " ", "Tahachal", "Kathmandu", "6am-8pm" ,"01-5381057", "https://goo.gl/maps/CkHcGCNuARbtaPHS9", 0))
        upsert(Futsal(130, "Taudaha Futsal", "Taudaha Trail", "Kirtipur", "Kathmandu", " ", "9840222482", "https://goo.gl/maps/3j6Fnac68DXTQxMq5", 0))
        upsert(Futsal(131, "Thali Futsal", " ", "Thali" ,"Kathmandu", "6am-9pm", "9851202815", "https://goo.gl/maps/S1L2ubg5QwVLyagy8", 0))
        upsert(Futsal(132, "The Game Futsal", " ", "Tokha", "Kathmandu", " ", "01-5158457", "https://goo.gl/maps/c9CdZ4amCwjHde9PA", 0))
        upsert(Futsal(133, "The Yellow House Futsal and Cafe", "Ekantakuna-Tikabhairab Rd", "Karyabinayak", "Lalitpur", "Open 24 hours", "9813133758", "https://goo.gl/maps/6XV9gLwFXyvkGt68A", 0))
        upsert(Futsal(134, "Trinetra Futsal Court", " ", "Chandragiri", "Kathmandu", "7am-10pm", "9823491122", "https://goo.gl/maps/8Z4XU8xejPTQXw9E6", 0))
        upsert(Futsal(135, "United Futsal", " ", "Kalanki", "Kathmandu", "6am-8pm", "01-5237599", "https://goo.gl/maps/7VVwuPbj1i9Bkdzt8", 0))
        upsert(Futsal(136, "Vajra Futsal", " ", "Dallu", "Kathmandu", "6am-8pm", " ", "https://goo.gl/maps/LMvnsFQZWgczzqfW6", 0))
        upsert(Futsal(137, "Visionova Recreation Centre", "Madannagar, Linkmarg", "Kuleshwor", "Kathmandu", "6am-8pm", "9861545401, 9849965444,9823837428, 9851276145", "https://goo.gl/maps/RjzETdUFiN6EGXM19", 0))
        upsert(Futsal(138, "Wakhat-Sunakothi Futsal", "Sunakothi", "Thecho", "Lalitpur", "6am-9pm", " ", "https://goo.gl/maps/rWKzShWFkX6JpKLU7", 0))
        upsert(Futsal(139, "Wembley Goals Futsal Arena", " ", "Lokanthali", "Bhaktapur", "6am-9pm", "01-6633470, 9860675627", "https://goo.gl/maps/iVYrssGta4Xkix9r5", 0))
        upsert(Futsal(140, "White Horse Futsal", "Nilopool", "Sukedhara", "Kathmandu", "5am-7pm", "01-4015067, 9849961991", "https://goo.gl/maps/fw7GxwPeRUrEvk9D7", 0))
        upsert(Futsal(141, "X-cel Futsal", "Namuna Galli", "Baluwatar", "Kathmandu", "6am-9pm", "01-4440857", "https://goo.gl/maps/E5nQCXb45XSrYwGK9", 0))
        upsert(Futsal(142, "Yala Futsal & Recreational Center", " ", "Imadol", "Mahalaxmi", "7am-9pm", "01-5200389", "https://goo.gl/maps/NRhr4pcjLXBxKup77", 0))
    }
}