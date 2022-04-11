package com.sk2apps.moviesassignment.ui.human_body

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.sk2apps.moviesassignment.R
import com.sk2apps.moviesassignment.databinding.ActivityImageSpotBinding
import com.sk2apps.moviesassignment.ui.blank.BlankActivity


class ImageSpotActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityImageSpotBinding
    private var fabOpenAnimation: Animation? = null
    private var fabCloseAnimation: Animation? = null
    private var isFabMenuOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_spot)
        binding = ActivityImageSpotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()

        getAnimations()

        binding.floatingActionButtonExpendOption.setOnClickListener {
            if (isFabMenuOpen) {
                collapseFabMenu()
            } else {
                expandFabMenu()
            }
        }
    }

    private fun initialize(){
        binding.textViewFrontBodyBtn.setOnClickListener(this)
        binding.textViewBackBodyBtn.setOnClickListener(this)
        binding.appCompatImageViewNeck.setOnClickListener(this)
        binding.appCompatImageViewKneeLeft.setOnClickListener(this)
        binding.appCompatImageViewKneeRight.setOnClickListener(this)
        binding.appCompatImageViewElbowLeft.setOnClickListener(this)
        binding.appCompatImageViewElbowRight.setOnClickListener(this)
        binding.appCompatImageViewHead.setOnClickListener(this)
        binding.appCompatImageViewChest.setOnClickListener(this)
        binding.appCompatImageViewHandLeft.setOnClickListener(this)
        binding.appCompatImageViewHandRight.setOnClickListener(this)
        binding.appCompatImageViewShoulderLeft.setOnClickListener(this)
        binding.appCompatImageViewShoulderRight.setOnClickListener(this)
        binding.appCompatImageViewThighLeft.setOnClickListener(this)
        binding.appCompatImageViewThighRight.setOnClickListener(this)
        binding.appCompatImageViewLegLeft.setOnClickListener(this)
        binding.appCompatImageViewLegRight.setOnClickListener(this)
        binding.appCompatImageViewFootLeft.setOnClickListener(this)
        binding.appCompatImageViewFootRight.setOnClickListener(this)
        binding.appCompatImageViewHipLeft.setOnClickListener(this)
        binding.appCompatImageViewHipRight.setOnClickListener(this)

        binding.appCompatImageViewBackBodyNeck.setOnClickListener(this)
        binding.appCompatImageViewBackBodyKneeLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyKneeRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyElbowLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyElbowRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyHead.setOnClickListener(this)
        binding.appCompatImageViewBackBodyChest.setOnClickListener(this)
        binding.appCompatImageViewBackBodyHandLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyHandRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyShoulderLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyShoulderRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyThighLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyThighRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyLegLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyLegRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyFootLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyFootRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyHipLeft.setOnClickListener(this)
        binding.appCompatImageViewBackBodyHipRight.setOnClickListener(this)
        binding.appCompatImageViewBackBodyWaist.setOnClickListener(this)
    }

    private fun getAnimations() {
        fabOpenAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabCloseAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_close)
    }

    private fun expandFabMenu() {
        ViewCompat.animate(binding.floatingActionButtonExpendOption).rotation(45.0f).withLayer()
            .setDuration(300).setInterpolator(OvershootInterpolator(10.0f)).start()
        binding.fabOption1.startAnimation(fabOpenAnimation)
        binding.fabOption2.startAnimation(fabOpenAnimation)
        binding.fabOption3.startAnimation(fabOpenAnimation)
        binding.fabOption4.startAnimation(fabOpenAnimation)
        binding.fabOption5.startAnimation(fabOpenAnimation)
        binding.fabOption6.startAnimation(fabOpenAnimation)
        binding.fabOption1.setClickable(true)
        binding.fabOption2.setClickable(true)
        binding.fabOption3.setClickable(true)
        binding.fabOption4.setClickable(true)
        binding.fabOption5.setClickable(true)
        binding.fabOption6.setClickable(true)
        isFabMenuOpen = true
    }

    private fun collapseFabMenu() {
        ViewCompat.animate(binding.floatingActionButtonExpendOption).rotation(0.0f).withLayer()
            .setDuration(300).setInterpolator(OvershootInterpolator(10.0f)).start()
        binding.fabOption1.startAnimation(fabCloseAnimation)
        binding.fabOption2.startAnimation(fabCloseAnimation)
        binding.fabOption3.startAnimation(fabCloseAnimation)
        binding.fabOption4.startAnimation(fabCloseAnimation)
        binding.fabOption5.startAnimation(fabCloseAnimation)
        binding.fabOption6.startAnimation(fabCloseAnimation)
        binding.fabOption1.setClickable(false)
        binding.fabOption2.setClickable(false)
        binding.fabOption3.setClickable(false)
        binding.fabOption4.setClickable(false)
        binding.fabOption5.setClickable(false)
        binding.fabOption6.setClickable(false)
        isFabMenuOpen = false
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this,BlankActivity::class.java)
        when(p0?.id){
            R.id.textViewFrontBodyBtn->{
                binding.constraintLayoutFrontBody.visibility = View.VISIBLE
                binding.constraintLayoutBackBody.visibility = View.GONE
                binding.textViewBodySideName.text = resources.getText(R.string.front_body)

                binding.constraintLayoutFrontBody.animate().alpha(1.0f)
                binding.constraintLayoutBackBody.animate().alpha(0.0f)
            }
            R.id.textViewBackBodyBtn->{
                binding.constraintLayoutFrontBody.visibility = View.GONE
                binding.constraintLayoutBackBody.visibility = View.VISIBLE
                binding.textViewBodySideName.text = resources.getText(R.string.back_body)

                binding.constraintLayoutFrontBody.animate().alpha(0.0f)
                binding.constraintLayoutBackBody.animate().alpha(1.0f)
            }
            R.id.appCompatImageViewNeck->{
                intent.putExtra("body_part", "Neck")
                startActivity(intent)
            }
            R.id.appCompatImageViewKneeLeft->{
                intent.putExtra("body_part", "Left Knee")
                startActivity(intent)
            }
            R.id.appCompatImageViewKneeRight->{
                intent.putExtra("body_part", "Right Knee")
                startActivity(intent)
            }
            R.id.appCompatImageViewElbowLeft->{
                intent.putExtra("body_part", "Left Elbow")
                startActivity(intent)
            }
            R.id.appCompatImageViewElbowRight->{
                intent.putExtra("body_part", "Right Elbow")
                startActivity(intent)
            }
            R.id.appCompatImageViewHead->{
                intent.putExtra("body_part", "Head")
                startActivity(intent)
            }
            R.id.appCompatImageViewChest->{
                intent.putExtra("body_part", "Chest")
                startActivity(intent)
            }
            R.id.appCompatImageViewHandLeft->{
                intent.putExtra("body_part", "Left Hand")
                startActivity(intent)
            }
            R.id.appCompatImageViewHandRight->{
                intent.putExtra("body_part", "Right Hand")
                startActivity(intent)
            }
            R.id.appCompatImageViewShoulderLeft->{
                intent.putExtra("body_part", "Left Shoulder")
                startActivity(intent)
            }
            R.id.appCompatImageViewShoulderRight->{
                intent.putExtra("body_part", "Right Shoulder")
                startActivity(intent)
            }
            R.id.appCompatImageViewThighLeft->{
                intent.putExtra("body_part", "Left Thigh")
                startActivity(intent)
            }
            R.id.appCompatImageViewThighRight->{
                intent.putExtra("body_part", "Right Thigh")
                startActivity(intent)
            }
            R.id.appCompatImageViewLegLeft->{
                intent.putExtra("body_part", "Left Leg")
                startActivity(intent)
            }
            R.id.appCompatImageViewLegRight->{
                intent.putExtra("body_part", "Right Leg")
                startActivity(intent)
            }
            R.id.appCompatImageViewFootLeft->{
                intent.putExtra("body_part", "Left Foot")
                startActivity(intent)
            }
            R.id.appCompatImageViewFootRight->{
                intent.putExtra("body_part", "Right Foot")
                startActivity(intent)
            }
            R.id.appCompatImageViewHipLeft->{
                intent.putExtra("body_part", "Left Hip")
                startActivity(intent)
            }
            R.id.appCompatImageViewHipRight->{
                intent.putExtra("body_part", "Right Hip")
                startActivity(intent)
            }

            R.id.appCompatImageViewBackBodyNeck->{
                intent.putExtra("body_part", "Neck")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyKneeLeft->{
                intent.putExtra("body_part", "Left Knee")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyKneeRight->{
                intent.putExtra("body_part", "Right Knee")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyElbowLeft->{
                intent.putExtra("body_part", "Left Elbow")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyElbowRight->{
                intent.putExtra("body_part", "Right Elbow")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyHead->{
                intent.putExtra("body_part", "Head")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyChest->{
                intent.putExtra("body_part", "Chest")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyHandLeft->{
                intent.putExtra("body_part", "Left Hand")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyHandRight->{
                intent.putExtra("body_part", "Right Hand")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyShoulderLeft->{
                intent.putExtra("body_part", "Left Shoulder")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyShoulderRight->{
                intent.putExtra("body_part", "Right Shoulder")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyThighLeft->{
                intent.putExtra("body_part", "Left Thigh")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyThighRight->{
                intent.putExtra("body_part", "Right Thigh")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyLegLeft->{
                intent.putExtra("body_part", "Left Leg")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyLegRight->{
                intent.putExtra("body_part", "Right Leg")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyFootLeft->{
                intent.putExtra("body_part", "Left Foot")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyFootRight->{
                intent.putExtra("body_part", "Right Foot")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyHipLeft->{
                intent.putExtra("body_part", "Left Hip")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyHipRight->{
                intent.putExtra("body_part", "Right Hip")
                startActivity(intent)
            }
            R.id.appCompatImageViewBackBodyWaist->{
                intent.putExtra("body_part", "Waist")
                startActivity(intent)
            }
        }
    }
}