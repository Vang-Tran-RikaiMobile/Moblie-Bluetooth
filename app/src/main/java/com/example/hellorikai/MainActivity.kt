package com.example.hellorikai

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val swBluetooth: Switch = findViewById<Switch>(R.id.swBT)
        val bluetoothApt: BluetoothAdapter? = bluetoothManager.adapter
        if (bluetoothApt == null){
            Toast.makeText( this, "This device does not support Bluetooth. Operations cannot be performed"
            , Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText( this, "Bluetooth support is successfully Detected!!"
                , Toast.LENGTH_LONG).show()
        }
    }
}