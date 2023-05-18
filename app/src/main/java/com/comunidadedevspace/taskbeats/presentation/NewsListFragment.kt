package com.comunidadedevspace.taskbeats.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.News


/**
 * A simple [Fragment] subclass.
 * Use the [NewsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsListFragment : Fragment() {

    private val adapter = NewsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvNewsList = view.findViewById<RecyclerView>(R.id.rv_news)
        rvNewsList.adapter = adapter

        // Fake list
        val newsList = listOf<News>(
            News(
                "The new \$149.99 Beats Studio Buds Plus improve upon the original model with better sound, more effective noise cancellation, and a unique translucent design. They also work better with Android than AirPods or the Beats Fit Pro.",
                "https://cdn.vox-cdn.com/thumbor/s8tP7IJg_n8INoJWKTcmy9PDS1g=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/24662269/DSCF0790_Enhanced_NR_2.jpg"
            ),
            News(
                "Anker’s Soundcore Liberty 3 Pro earbuds are on sale today at Amazon, Walmart, and other retailers for just \$84.99. You can also save on Samsung’s 32-inch M8 Smart Monitor and Pro Plus microSD card, just in time for the latest Zelda title.",
                "https://cdn.vox-cdn.com/thumbor/JTE9fnQTl8PaIDcunL_g4i-HlkY=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/23260738/DSCF7274.jpg"
            ),
            News(
                "Amazon has announced a new version of its Echo Buds earbuds with a lightweight, open-ear design. The \$49.99 earbuds will offer up to five hours of continuous battery life, hands-free Alexa voice commands, and multipoint Bluetooth support.",
                "https://cdn.vox-cdn.com/thumbor/TkGsMWWte-HD4n87FrbahVzhaw4=/0x0:2040x1275/1200x628/filters:focal(1020x638:1021x639)/cdn.vox-cdn.com/uploads/chorus_asset/file/24660785/EchoBudsCase.jpg"
            ),
            News(
                "Listeners can access all New York Times podcasts as well as stories from The Athletic, Serial, This American Life, and others.",
                "https://cdn.vox-cdn.com/thumbor/2tTpkCGR6I2gdkIiV6v2hKi0mcU=/0x0:1674x930/1200x628/filters:focal(820x417:821x418)/cdn.vox-cdn.com/uploads/chorus_asset/file/24664448/Screen_Shot_2023_05_17_at_1.39.01_PM.png"
            ),
            News(
                "The companies will only stock MX Master and MX Anywhere mouse parts at first.",
                "https://cdn.arstechnica.net/wp-content/uploads/2023/05/logitech_padremoval_100KB.jpg"
            )
        )

        adapter.submitList(newsList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment NewsListFragment.
         */
        @JvmStatic
        fun newInstance() =
            NewsListFragment()
    }
}