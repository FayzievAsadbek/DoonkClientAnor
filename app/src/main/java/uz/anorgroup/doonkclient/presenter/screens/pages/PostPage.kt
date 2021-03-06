package uz.anorgroup.doonkclient.presenter.screens.pages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.anorgroup.doonkclient.R
import uz.anorgroup.doonkclient.databinding.PagePostBinding

@AndroidEntryPoint
class PostPage : Fragment(R.layout.page_post) {
    private val bind by viewBinding(PagePostBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.saveBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreen_to_newOrderScreen)
        }
    }
}