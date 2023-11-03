package SecondApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.iniciandokotlin.R

class ResultadoActivity : AppCompatActivity() {

    private lateinit var tvResultado:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescripcion:TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val resultado:Double = intent.extras?.getDouble("imc") ?: -1.0

        initComponent()
        initUi(resultado)
        initListeners()
    }





    private fun initListeners() {
        btnCalculate.setOnClickListener { finish() }
    }


    private fun initUi(resultado: Double) {
        tvIMC.text = resultado.toString()
        when(resultado) {
            in 0.00..18.50 -> { //bajo peso
                tvResultado.text = getString(R.string.titulo_BP)
                tvDescripcion.text = getString(R.string.descripcion_BP)
            }

            in 18.51..24.99 -> { //peso normal
                tvResultado.text = getString(R.string.titulo_PN)
                tvDescripcion.text = getString(R.string.descripcion_PN)
            }

            in 25.00..29.99 -> { //sobrePeso
                tvResultado.text = getString(R.string.titulo_SP)
                tvDescripcion.text = getString(R.string.descripcion_SP)
            }

            in 30.00..99.99 -> { //obesidad
                tvResultado.text = getString(R.string.titulo_O)
                tvDescripcion.text = getString(R.string.descripcion_O)
            }

            else -> { //error
                tvResultado.text = "error"
                tvIMC.text = "error"
                tvDescripcion.text = "error"
            }
        }
    }

    private fun initComponent() {
        tvResultado = findViewById(R.id.tvResultado)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        btnCalculate = findViewById(R.id.btnCalculate)
    }
}