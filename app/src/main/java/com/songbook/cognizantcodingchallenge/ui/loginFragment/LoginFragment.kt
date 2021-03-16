package com.songbook.cognizantcodingchallenge.ui.loginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.songbook.cognizantcodingchallenge.R
import com.songbook.cognizantcodingchallenge.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

        binding.loginBtn.setOnClickListener {

            viewModel.state.observe(viewLifecycleOwner) { state ->

                when (state) {
                    is LoginViewModel.LoginState.ShowEmailEmptyError -> setEmailEmptyError()
                    is LoginViewModel.LoginState.ShowPasswordEmptyError -> setPasswordEmptyError()
                    is LoginViewModel.LoginState.ShowInvalidEmailError -> setTillEmailError()
                    is LoginViewModel.LoginState.ShowInvalidPasswordError -> setTillPasswordError()
                    is LoginViewModel.LoginState.ShowEmailErrorNull -> removeEmailError()
                    is LoginViewModel.LoginState.ShowPasswordErrorNull -> removePasswordError()
                }

            }

            if (viewModel.allFieldsValid(getEmail(), getPassword())) {
                loginSuccessToast()
                goToListFragment()
            }
        }

    }


    private fun setupViewModel() {

        viewModel = ViewModelProvider(
            this, LoginViewModelFactory()
        ).get(LoginViewModel::class.java)

    }

    private fun getEmail(): String {
        return binding.etEmail.text.toString()
    }

    private fun getPassword(): String {
        return binding.etPassword.text.toString()
    }

    private fun setTillEmailError() {
        binding.tilEmail.error = getString(R.string.email_address_error)
    }

    private fun setTillPasswordError() {
        binding.tilPassword.error = getString(R.string.password_error)
    }

    private fun setEmailEmptyError() {
        binding.tilEmail.error = getString(R.string.email_empty_error)
    }

    private fun setPasswordEmptyError() {
        binding.tilPassword.error = getString(R.string.password_empty_error)
    }

    private fun removeEmailError() {
        binding.tilEmail.error = null
    }

    private fun removePasswordError() {
        binding.tilPassword.error = null
    }

    private fun loginSuccessToast() {
        Toast.makeText(requireContext(), getString(R.string.loginSuccess), Toast.LENGTH_SHORT)
            .show()
    }

    private fun goToListFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToListFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


