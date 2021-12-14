package br.com.vinnom.viperexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.vinnom.viperexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}