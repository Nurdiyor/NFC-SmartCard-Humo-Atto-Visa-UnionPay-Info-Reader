# NFC-SmartCard-Humo-Atto-Visa-UnionPay-Info-Reader
## allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
## }
  
##  dependencies {
	        implementation 'com.github.Nurdiyor:NFC-SmartCard-Humo-Atto-Visa-UnionPay-Info-Reader:0.1.0'
## }
## Example:{
package uz.micro.star.examplecardreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import uz.micro.star.examplecardreader.databinding.ActivityMainBinding
import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.CardNfcManager
import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.SPEC
import uz.micro.star.humo_atto_visa_union_pay_nfc_info_reader.nfc.bean.Card

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mCardNfcManager: CardNfcManager
    private var mSafeExit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mCardNfcManager =
                CardNfcManager(
                        this
                )
        onNewIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (!mCardNfcManager.readCard(intent) { event, objs ->
                    if (event == SPEC.EVENT.IDLE) {
                        //            showProgressBar();
                    } else if (event == SPEC.EVENT.FINISHED) {
                        //            hideProgressBar();
                        val card: Card? = if (objs.isNotEmpty()) objs[0] as Card? else null
                        buildResult(card)
                    }
                }) {
            Toast.makeText(this, "Xatolik !!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun buildResult(card: Card?) {
        if (card != null && !card.hasReadingException()) {
            if (card.isUnknownCard) {
//    ret.putExtra(RET, NfcReaderApplication.getStringResource(R.string.info_nfc_unknown));
            } else {
                binding.nfcInfo.text =
                        card.serialAndDate.cardNumber + "\n" + card.serialAndDate.cardExpiredDate
                Toast.makeText(this, binding.nfcInfo.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("SERIAL", "buildResult: " +  binding.nfcInfo.text.toString())
            }
        } else {
//            ret.putExtra(RET,NfcReaderApplication.getStringResource(R.string.info_nfc_error));
        }
    }

    override fun onBackPressed() {
        if (mSafeExit) {
            super.onBackPressed()
        }
    }

    override fun onPause() {
        mCardNfcManager.onPause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mCardNfcManager.onResume()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            if (mCardNfcManager.updateStatus()) {
                //loadDefaultPage
            }
            Handler().postDelayed({ mSafeExit = true }, 800)
        } else {
            mSafeExit = false
        }
    }
}
## }
