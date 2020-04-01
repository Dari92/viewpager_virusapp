package com.kotlincourse.virusapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kotlincourse.virusapp.R
import kotlinx.android.synthetic.main.item_onboard.view.*

class OnBoardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val pages = arrayListOf(R.color.color1, R.color.color2, R.color.color3, R.color.color4)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_onboard, parent, false))


    override fun getItemCount(): Int = pages.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.run {
            when(position){
                0 -> {textViewWlcome.text = "This is CoronaVirus"
                 lottieAnimation.setAnimation(R.raw.virus)
                textViewDescription.text = "All the information related to the CoronaVirus. Lorem Ipsum is simply dummy text of the printing and typesetting industry."
                    buttonNext.visibility = View.INVISIBLE
                                 }
                1 -> {textViewWlcome.text = "The prevention is the Key"
                    lottieAnimation.setAnimation(R.raw.prevention)
                    textViewDescription.text = "Know all the General Prevention and Control Measures "
                    buttonNext.visibility = View.INVISIBLE
                                }
                2 -> {textViewWlcome.text = "AutoTest"
                    lottieAnimation.setAnimation(R.raw.symptoms)
                    textViewDescription.text = "Monitor your symptoms, " +
                            "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
                    buttonNext.visibility = View.INVISIBLE
                                }
                3 -> {textViewWlcome.text = "Professional Attention"
                    lottieAnimation.setAnimation(R.raw.hospital)
                    textViewDescription.text = "If your symptoms are suspicious, send a notification to the nearest attention center"
                    buttonNext.visibility = View.VISIBLE



                }
            }
            clOnboard.setBackgroundColor(ContextCompat.getColor(context, pages[position]))
/*
            buttonNext.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, Main2Activity::javaClass)
            context.startActivity(intent)
            } */
        }


    }


}