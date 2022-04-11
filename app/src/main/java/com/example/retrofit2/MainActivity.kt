package com.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.retrofit2.databinding.ActivityMainBinding
import com.example.retrofit2.models.User
import com.example.retrofit2.retrofit.ApiClient
import com.example.retrofit2.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiClient.getRetrofit().create(RetrofitService::class.java).getUsers().enqueue(object:retrofit2.Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    val list = ArrayList<String>()
                    val l = response.body()!!
                    l.forEach{
                        list.add(it.CcyNm_EN)
                    }
                    val arrayAdapter = ArrayAdapter(this@MainActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list)
                    binding.rvMain.adapter = arrayAdapter
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })
    }
}