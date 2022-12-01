package com.example.vroomvroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var num1: EditText = findViewById(R.id.asoebi1)
        var num2: EditText = findViewById(R.id.asoebi2)
        var digits: EditText = findViewById(R.id.digits)
        var registracia: Button = findViewById(R.id.button)
        var telefoni: EditText = findViewById(R.id.mobile)
        var piradi: EditText = findViewById(R.id.piradi)

        registracia.setOnClickListener {
            var num1ok = false
            var digitsok = false
            var telefoniok = false
            var piradiok = false
            var errorr = ""
            if(digits.text.toString().length == 3 && digits.text.toString().isDigitsOnly()){
                digitsok = true
            }else{
                errorr = "სწორად შეიყვანე მანქანის ნომრის ციფრები"
            }
            if(telefoni.text.toString().length == 9 && telefoni.text.toString().isDigitsOnly() && telefoni.text.toString().first()=='5'){
                telefoniok = true
            }else{
                errorr = "სწორად შეიყვანე მობილურის ნომერი"
            }
            if(piradi.text.toString().length == 11 && piradi.text.toString().isDigitsOnly()){
                piradiok = true
            }else{
                errorr = "სწორად შეიყვანე პირადი ნომერი"
            }
            var checker1 = false
            var checker2 = false
            for(i in num1.text.toString()){
                if(i.isLetter()) {
                    checker1 = true
                }else{
                    errorr= "სწორად შეიყვანე მანქანის ნომრის ასოები"
                }
                }
            for(i in num2.text.toString()){
                if(i.isLetter()){
                    checker2 = true
                }else{
                   errorr= "სწორად შეიყვანე მანქანის ნომრის ასოები"
                }
            }
            if(num1.text.toString().length == 2 && num2.text.toString().length == 2 ){
                num1ok=true
            }else{
                errorr = "სწორად შეიყვანე მანქანის ნომრის ასოები"
            }
            if(digitsok&&telefoniok&&piradiok&&num1ok&&checker1&&checker2){
                Toast.makeText(this, "თქვენ წარმატებით გაიარეთ რეგისტრაცია", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "$errorr", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

