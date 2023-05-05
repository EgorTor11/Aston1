package com.taranovegor91.aston1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            btnEntity.setOnClickListener {
              showModel(Entity(0,"Nester"))
            }
            btnModelka.setOnClickListener{
                showModel(Modelka(0,"Nester","Pavlov"))
            }
        }
    }

    private fun showModel(model: EntityVariant) {
        when (model) {
            is Entity -> binding.textView.text = "${model.id} ${model.name}"
            is Modelka -> binding.textView.text = "${model.id} ${model.firstName} ${model.lastName}"
        }
    }
}