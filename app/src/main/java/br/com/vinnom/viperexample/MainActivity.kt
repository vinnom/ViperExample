package br.com.vinnom.viperexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.vinnom.viperexample.databinding.ActivityMainBinding
import br.com.vinnom.viperexample.view.GetRandomReferenceFragmentView

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        displayGetRandomReferenceView(savedInstanceState)
    }

    private fun displayGetRandomReferenceView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.apply {
                add(binding.fragmentContainerView.id, GetRandomReferenceFragmentView())
                setReorderingAllowed(true)
            }
            transaction.commit()
        }
    }
}