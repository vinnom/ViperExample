package br.com.vinnom.viperexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.vinnom.viperexample.databinding.ActivityMainBinding
import br.com.vinnom.viperexample.view.GetRandomReferenceFragmentView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.apply {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, GetRandomReferenceFragmentView())
            }
            transaction.commit()
        }
    }
}