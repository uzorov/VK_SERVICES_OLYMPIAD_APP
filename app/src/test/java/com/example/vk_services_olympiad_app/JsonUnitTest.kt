package com.example.vk_services_olympiad_app

import com.example.vk_services_olympiad_app.view_model.ServicesViewModel
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class JsonUnitTest {

    @Test
    fun RetrofotTest() {
    val a = ServicesViewModel()
    print(a.status.value.toString());
    }

}