package com.oguzel.marsrealestate

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.oguzel.marsrealestate.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignIn.setOnClickListener {
            loginAuth(binding.editTextUsername, binding.editTextPassword, binding.splashAnimation)
        }
    }

    private fun loginAuth(username: EditText, password: EditText, animation: LottieAnimationView) {
        if (username.text.toString() == "admin" && password.text.toString() == "admin") {
            //Login Successful
            animation.visibility = View.VISIBLE
            animation.playAnimation()
            Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_loginFragment_to_main_graph)
            }, 5000)
        } else {
            //Login Failed
            Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}
