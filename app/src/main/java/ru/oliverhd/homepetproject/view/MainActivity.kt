package ru.oliverhd.homepetproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.oliverhd.homepetproject.databinding.ActivityMainBinding
import ru.oliverhd.homepetproject.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter1.setOnClickListener {
            presenter.counterOneClick()
        }
        binding.btnCounter2.setOnClickListener {
            presenter.counterTwoClick()
        }
        binding.btnCounter3.setOnClickListener {
            presenter.counterThreeClick()
        }
    }

    override fun setButtonOneText(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setButtonTwoText(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setButtonThreeText(text: String) {
        binding.btnCounter3.text = text
    }
}