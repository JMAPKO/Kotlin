package firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.iniciandokotlin.R

class FirstAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnUno = findViewById<AppCompatButton>(R.id.btnUno)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        btnUno.setOnClickListener {
            val name = etName.text.toString()

            if (name.isNotEmpty()){
                val traerName = Intent(this,traerNombre::class.java)
                traerName.putExtra("valor",name)
                startActivity(traerName)
            }
        }

    }
}