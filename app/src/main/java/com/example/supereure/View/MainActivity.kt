package com.example.supereure.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.supereure.Data.Model.Superheroe
import com.example.supereure.Data.Network.Api
import com.example.supereure.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun GetHeroe() {
        Api.buildSuerheroes.GetAllHeroes().enqueue(object : Callback<List<Superheroe>> {
            //aki es dodne se inplementa la logica al obtener una respuesta
            override fun onResponse(
                call: Call<List<Superheroe>>,
                response: Response<List<Superheroe>>
            ) {
                var a = response.body()

                a?.forEach { superheroe ->
                    binding.txt.append(superheroe.Nombre)
                }

            }

            //aki se dice loq eu va a hacer si ocurre un error
            override fun onFailure(call: Call<List<Superheroe>>, t: Throwable) {
                Log.e("Error de esa vaina", t.message.toString())
            }
        })


    }

    fun GetforId(id: String) {
        Api.buildSuerheroes.GetHeroesByID(id).enqueue(object : Callback<Superheroe> {
            override fun onResponse(call: Call<Superheroe>, response: Response<Superheroe>) {
                var a = response.body()
                binding.txt.text = a?.Nombre
            }

            override fun onFailure(call: Call<Superheroe>, t: Throwable) {
                Log.e("Error de esa otra vaina", t.message.toString())
            }
        })

    }

    fun PostHeroe() {

        var cuerpo = Superheroe(10, "Flash", "1974", "Tierra", "12345")

        var token = Api.tokent

        Api.buildSuerheroes.PostHeroe(token, cuerpo).enqueue(object : Callback<Superheroe> {
            override fun onResponse(call: Call<Superheroe>, response: Response<Superheroe>) {
                Toast.makeText(this@MainActivity, "ya ta registrao", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Superheroe>, t: Throwable) {
                Log.e("Error de esa otra cosa", t.message.toString())
            }
        })


    }

    fun Delete(id: String) {
        var token = Api.tokent
        Api.buildSuerheroes.DeleteHeroe(token, id).enqueue(object : Callback<Superheroe> {
            override fun onResponse(call: Call<Superheroe>, response: Response<Superheroe>) {
                Toast.makeText(this@MainActivity, "ya ta eliminao", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Superheroe>, t: Throwable) {
                Log.e("Error de esa otra vaina", t.message.toString())
            }
        })

    }

    fun PutHeroe(id: String) {

        var cuerpo = Superheroe(10, "Flash", "1974", "Tierra", "12345")
        var token = Api.tokent

        Api.buildSuerheroes.PutHeroe(token, id, cuerpo).enqueue(object : Callback<Superheroe> {
            override fun onResponse(call: Call<Superheroe>, response: Response<Superheroe>) {
                Toast.makeText(this@MainActivity, "ya ta actualizao", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Superheroe>, t: Throwable) {
                Log.e("Error de esa otra vaina", t.message.toString())
            }
        })


    }

}

