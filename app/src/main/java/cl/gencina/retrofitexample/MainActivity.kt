package cl.gencina.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.gencina.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}