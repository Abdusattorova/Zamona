package com.example.zamona

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.zamona.databinding.ActivityMain2Binding
import java.util.*

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var sharedPreferences2: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private val  channelId="salom"
    var batton=""
    var a=0
    var pinkod=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sms.setOnClickListener {
    if (batton.isNotEmpty()&& batton==pinkod)
    {
        sharedPreferences2=this.getSharedPreferences("kk", MODE_PRIVATE)
        editor=sharedPreferences2.edit()
        a=1
        editor.putInt("keyyy",a)
        editor.commit()
    }
}

        binding.next.setOnClickListener {

                intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)


        }

        setData()
        sendNotifications()
        finish()
    }
    private fun setData() {
        binding.PnidWiev.requestFocus()
        val inputMethodManager=binding.root.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        binding.PnidWiev.onFocusChangeListener= View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                inputMethodManager.showSoftInput(binding.PnidWiev, 0)
            }
            else{
                inputMethodManager.hideSoftInputFromWindow(binding.PnidWiev.windowToken, 0)
            }


        }
        binding.PnidWiev.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                batton=s.toString()
                if (s.toString().length == 4){
                    if (pinkod==s.toString()){
                       inputMethodManager.hideSoftInputFromWindow(binding.PnidWiev.windowToken, 0)
                        var intent=Intent(this@MainActivity2,MainActivity3::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(binding.root.context, "Tasdiqlash kodi xato!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun afterTextChanged(s: Editable?){}
        })

    }
    private fun sendNotifications(){
        val random = Random()
        pinkod="${random.nextInt(9)}${random.nextInt(9)}${random.nextInt(9)}${random.nextInt(9)}"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val notificationChannel = NotificationChannel(channelId, "Notification", importance)
            val builder = Notification.Builder(binding.root.context, channelId)
                .setSmallIcon(R.drawable.salom)
                .setContentTitle("Tasdiqlash kodi")
                .setContentText(pinkod)
            val notificationManager = this?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            notificationManager.notify(1, builder.build())
        }
    }

}