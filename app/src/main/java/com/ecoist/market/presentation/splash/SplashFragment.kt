package com.ecoist.market.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.ecoist.market.R
import com.ecoist.market.util.oneTimeCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oneTimeCoroutineScope(Dispatchers.Main) {
            launch {
                delay(1000)

                val builder: NavOptions.Builder = NavOptions.Builder()
                val action =
                    SplashFragmentDirections.actionSplashFragmentToCategoryMainListFragment()
                findNavController().navigate(action, builder.build())
            }
        }
    }
}