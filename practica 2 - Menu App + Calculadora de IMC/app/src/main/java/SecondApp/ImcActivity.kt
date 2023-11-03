package SecondApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.iniciandokotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var maleSelected:Boolean = true
    private var femaleSelected:Boolean = false
    private var pesoActual:Int = 60
    private var edadActual:Int = 18
    private var alturaActual:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvAltura:TextView
    private lateinit var rsAltura: RangeSlider
    private lateinit var  btnSumarPeso: FloatingActionButton
    private lateinit var  btnBajarPeso: FloatingActionButton
    private lateinit var tvPeso:TextView
    private lateinit var btnMasEdad: FloatingActionButton
    private lateinit var btnMenosEdad: FloatingActionButton
    private lateinit var tvEdad:TextView
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
        initUi()

    }



    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvAltura = findViewById(R.id.tvAltura)
        rsAltura = findViewById(R.id.rsAltura)
        btnSumarPeso = findViewById(R.id.btnSumarPeso)
        btnBajarPeso = findViewById(R.id.btnBajarPeso)
        tvPeso = findViewById(R.id.tvPeso)
        btnMasEdad = findViewById(R.id.btnMasEdad)
        btnMenosEdad = findViewById(R.id.btnMenosEdad)
        tvEdad = findViewById(R.id.tvEdad)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        
        //METODO DE Seleccion de Genero
        viewMale.setOnClickListener{
            cambiarGenero()
            setColorGenero()
        }
        viewFemale.setOnClickListener{
            cambiarGenero()
            setColorGenero()
        }
        
        //METODO DEL RangeSlider
        rsAltura.addOnChangeListener { _,value,_ ->
            val nuevoValor = DecimalFormat("#.##")
            alturaActual = nuevoValor.format(value).toInt()
            tvAltura.text = "$alturaActual cm"
        }

        //SELECCIONAR BOTONES DE PESO
        btnSumarPeso.setOnClickListener {
            pesoActual += 1
            setPeso()
        }
        btnBajarPeso.setOnClickListener {
            pesoActual -= 1
            setPeso()
        }
        // SELECCIOANR EDAD
        btnMasEdad.setOnClickListener {
            edadActual += 1
            setEdad()
        }
        btnMenosEdad.setOnClickListener {
            edadActual -= 1
            setEdad()
        }

        //SELECIONAR CALULAR
        btnCalculate.setOnClickListener {
            val resultado = calculateIMC()
            navigateToResultado(resultado)
        }

    }

    private fun navigateToResultado(resultado: Double) {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("imc",resultado)
        startActivity(intent)

    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = pesoActual/(alturaActual.toDouble()/100 * alturaActual.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setEdad() {
        tvEdad.text = edadActual.toString()
    }

    private fun setPeso() {
        tvPeso.text = pesoActual.toString()
    }

    private fun cambiarGenero() {
        maleSelected = !maleSelected
        femaleSelected = !femaleSelected
    }

    private fun setColorGenero() {
        viewMale.setCardBackgroundColor(traerColorFondo(maleSelected))
        viewFemale.setCardBackgroundColor(traerColorFondo(femaleSelected))
    }

    private fun traerColorFondo(valorSeleccionado:Boolean):Int {
        val colorS = if (valorSeleccionado){
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this,colorS)
    }


    private fun initUi(){
        setColorGenero()
        setPeso()
        setEdad()
    }

}