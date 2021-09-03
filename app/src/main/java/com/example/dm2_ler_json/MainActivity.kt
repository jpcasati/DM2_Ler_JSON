package com.example.dm2_ler_json

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLerLivro.setOnClickListener {

            val user = "jp"

            val url = "http://10.0.2.2/dm2_teste_json/index.php?user=$user"

            val resp = Fundo(url).execute().get()

            val livro = JSONObject(resp)

            txtIsbn.text = livro.getString("isbn")
            txtTitulo.text = livro.getString("titulo")
            txtAutor.text = livro.getString("autor")

            Toast.makeText(this, livro.getString("usuario"), Toast.LENGTH_LONG).show()

        }

    }

    class Fundo(url: String) : AsyncTask<Void, Void, String>() {

        val url = url

        override fun doInBackground(vararg params: Void?): String? {
            // a tarefa a ser executada em segundo plano

            val apiResponse = URL(url).readText()

            return apiResponse
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // o que ele deve executar antes de realizar a tarefa

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // o que ele deve executar após realizar a tarefa

        }
    }
}