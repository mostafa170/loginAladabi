package com.alamat.aladabilogin.ui.splashScreen

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.alamat.aladabilogin.R
import com.alamat.aladabilogin.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    lateinit var binding: FragmentSplashScreenBinding

    var handler: Handler? = null
    var runnable: Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil
            .inflate(inflater!!, R.layout.fragment_splash_screen, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setDisplayedTime()
    }

     override fun onStop() {
        handler!!.removeCallbacks(runnable!!)
        super.onStop()
    }


     override fun onDestroy() {
        handler!!.removeCallbacks(runnable!!)
        super.onDestroy()
    }
    fun setDisplayedTime() {
        handler = Handler()
        runnable = Runnable {
//            if (UserPreferenceHelper.isLogined()) {
//                if (UserPreferenceHelper.getUserProfile().getRegistrationCaptianModel()
//                        .isCompletedProfile()
//                ) {
//                    if (UserPreferenceHelper.getUserProfile().getRegistrationCaptianModel()
//                            .getBankName() == null
//                    ) {
//                       MovementHelper.startBaseActivity(
//                            this@SplashActivity,
//                            Constants.BANK_ACCOUNT_PAGE,
//                            null
//                        )
//                    } else {
//                        MovementHelper.startMainActivity(this@SplashActivity, Constants.HOME_PAGE)
//                    }
//                } else {
//                    MovementHelper.startBaseActivity(
//                        this@SplashActivity,
//                        Constants.LOGIN_PAGE, null
//                    )
//                }
//            } else {
                       Navigation.findNavController(requireView()).navigate(R.id.action_fragmentSplashScreen_to_loginFragment)
//            }
//            getActivity()?.finish()
        }
        handler!!.postDelayed(runnable!!, 5000)
    }

}