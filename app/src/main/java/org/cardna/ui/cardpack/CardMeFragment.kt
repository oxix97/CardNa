import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import org.cardna.base.baseutil.BaseViewUtil
import org.cardna.data.remote.model.cardpack.ResponseCardpackCardmeData
import org.cardna.databinding.FragmentCardMeBinding
import org.cardna.ui.cardpack.CardPackRvAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class CardMeFragment :
    BaseViewUtil.BaseFragment<FragmentCardMeBinding>(org.cardna.R.layout.fragment_card_me) {

    private lateinit var cardPackRvAdapter: CardPackRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun initView() {
        initCardmeRvAdapter()
    }

    private fun initCardmeRvAdapter() {
        cardPackRvAdapter = CardPackRvAdapter()

        binding.rvCardme.adapter = cardPackRvAdapter

        // make GridLayout
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCardme.layoutManager = gridLayoutManager

        // Gridlayout 간격

        binding.rvCardme.addItemDecoration(SpacesItemDecoration(12))

        cardPackRvAdapter.cardList.addAll(
            listOf(
                ResponseCardpackCardmeData("img url", 1, "댕댕이 짱 좋아"),
                ResponseCardpackCardmeData("img url", 1, "댕댕이 짱 좋아"),
                ResponseCardpackCardmeData("img url", 1, "댕댕이 짱 좋아"),
                ResponseCardpackCardmeData("img url", 1, "댕댕이 짱 좋아"),
                ResponseCardpackCardmeData("img url", 1, "댕댕이 짱 좋아"),
                ResponseCardpackCardmeData("img url", 1, "댕댕이 짱 좋아")
            )
        )

        cardPackRvAdapter.notifyDataSetChanged()
    }

    class SpacesItemDecoration(private val space: Int) : ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.right = space
            outRect.bottom = space

        }
    }
}
