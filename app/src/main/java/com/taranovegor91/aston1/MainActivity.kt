package com.taranovegor91.aston1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.taranovegor91.aston1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val entity = Entity(0, "Jon")
        Toast.makeText(this, "${entity.id} ${entity.name}", Toast.LENGTH_SHORT).show()
        with(binding) {
            var id = 0
            btnEntity.setOnClickListener {
                showModel(Entity(id, "Nester").also {
                    id++
                    Log.d("myLog", it.name + it.id)
                })
                Entity(id, "Mark").let {
                    Log.d("myLog", it.toString())
                }
                Modelka(id, "Mark", "Markov").run { Log.d("myLog", this.toString()) }
            }

            btnModelka.setOnClickListener {
                showModel(Modelka(0,
                    "Nester",
                    "Pavlov").apply { lastName += " " + ('a'..'z').random() })
            }
        }

    }

    private fun showModel(model: EntityVariant) {
        when (model) {
            is Entity -> binding.textView.text = "${model.id} ${model.name}"
            is Modelka -> binding.textView.text = "${model.id} ${model.firstName} ${model.lastName}"
            else -> binding.textView.text = "else"
        }
    }

}