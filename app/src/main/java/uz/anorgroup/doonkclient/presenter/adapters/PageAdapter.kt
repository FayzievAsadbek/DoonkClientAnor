package uz.anorgroup.doonkclient.presenter.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.anorgroup.doonkanorgroup.presenter.screens.pages.*
import uz.anorgroup.doonkclient.presenter.screens.pages.ProfilePage
import uz.anorgroup.doonkclient.presenter.screens.pages.TripPage

class PageAdapter(
    frm: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(frm, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val trip = TripPage()
                trip
            }
            1 -> {
                val searchPage = SearchPage()
                searchPage
            }
            2 -> {
                val create = CreateTripPage()
                create
            }
            3 -> {
                val chatPage = ChatPage()
                chatPage
            }
            else -> {
                val profilePage = ProfilePage()
                profilePage
            }
        }
    }


    override fun getItemCount(): Int = 5
}