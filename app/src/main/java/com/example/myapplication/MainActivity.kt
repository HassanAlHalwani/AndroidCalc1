package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.*
//import com.google.android.material.navigation.NavigationBarView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        //global variable
        var flag : String = "Sum"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("sum","multiply","division","subtraction","root","power")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )


        button.setOnClickListener{ view ->
            //code here
            var x: Float = edtxt1.text.toString().toFloat();
            var y: Float = edtxt2.text.toString().toFloat();
            if(flag =="sum")
                resultTV.text = sum(x,y).toString();
            else if (flag =="multiply")
                resultTV.text = multiply(x,y).toString();
            else if (flag =="division"){
                if(division(x,y)==9.999999){
                Toast.makeText(this, "Divide by zero is not acceptable",Toast.LENGTH_LONG).show()
                    resultTV.text ="Math Error"        }
               else {resultTV.text = division(x,y).toString();}


            }
            else if (flag =="subtraction")
                resultTV.text = subtraction(x,y).toString();
            else if (flag =="root")
                resultTV.text = root(x,y).toString();
            else if (flag =="power")
                resultTV.text = power(x,y).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun sum(a: Float, b: Float): Float {
    return a+b
}
public fun multiply(a: Float, b: Float): Float {
    return a*b
}
public fun division(a: Float, b: Float): Double {
    if(b.toInt()!=0){
        return a.toDouble()/b}
    else{
        return 9.999999}
}
public fun subtraction(a: Float, b: Float): Float {
    return a-b
}
public fun root(a: Float, b: Float): Double {
    return Math.sqrt(a.toDouble())
}
public fun power(a: Float, b: Float): Double {
    return Math.pow(a.toDouble(), b.toDouble())
}