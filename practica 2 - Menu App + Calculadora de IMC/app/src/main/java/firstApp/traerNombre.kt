package firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.iniciandokotlin.R

class traerNombre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traer_nombre)
        val nombre = findViewById<TextView>(R.id.nombre)
        val name: String = intent.extras?.getString("valor").orEmpty()

        nombre.text = "Hola! $name.. Bienvenid@!!!"
    }
}