package MenuMain

import SecondApp.ImcActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.iniciandokotlin.R
import firstApp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaluApp = findViewById<AppCompatButton>(R.id.btnSaluApp)
        btnSaluApp.setOnClickListener { usarSaluApp() }

        val btnImcApp = findViewById<AppCompatButton>(R.id.btnImcApp)
        btnImcApp.setOnClickListener { usarImcApp() }
    }

    private fun usarImcApp() {
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }

    private fun usarSaluApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}