package com.appschool.androidclass.bottombar.ui.home

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.appschool.androidclass.bottombar.R
import com.appschool.androidclass.bottombar.databinding.FragmentHomeBinding
import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val job = Job()
        val scopeIO = CoroutineScope( job + Dispatchers.IO )
        val scope = CoroutineScope( job + Dispatchers.Main )

        binding.button.setOnClickListener {
            Log.i("scope","in Main before scope")

            scopeIO.launch {
                B()
                Log.i("scope","1st Scope Finished")
            }
            scopeIO.launch {
                A()
                Log.i("scope","2nd Scope Finished")
            }
            scopeIO.launch {
                launch {
                    CwithContextIO()

                }
                DwithContextMain()
            }

            Log.i("scope","in Main after scope")
        }



        Log.i("check", "F onCreateView")
        return binding.root
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.i("check", "F onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("check", "F onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("check", "F onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("check", "F onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("check", "F onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("check", "F onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("check", "F onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("check", "F onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("check", "F onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("check", "F onDetach")
    }


    suspend fun A () {
        for (item in 1 .. 5) {
            delay(1000L)
            Log.i("scope","A $item")
        }
    }
    suspend fun B () {

        for (item in 1 .. 5) {
            delay(1000L)
            Log.i("scope","B $item")
        }
    }

    suspend fun CwithContextIO () {
        withContext(Dispatchers.IO){
            for (item in 1 .. 5) {
                delay(1000L)
                Log.w("scope","C $item")
            }
            return@withContext
        }
    }
    suspend fun DwithContextMain () {
        withContext(Dispatchers.Main){
            for (item in 1 .. 5) {
                delay(1000L)
                Log.w("scope","D $item")
            }
            return@withContext
        }
    }







}