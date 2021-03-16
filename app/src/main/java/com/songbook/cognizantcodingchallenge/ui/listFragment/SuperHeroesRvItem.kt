package com.songbook.cognizantcodingchallenge.ui.listFragment

import android.view.View
import com.songbook.cognizantcodingchallenge.R
import com.songbook.cognizantcodingchallenge.databinding.ItemSuperHeroesBinding
import com.songbook.cognizantcodingchallenge.model.SuperHero
import com.xwray.groupie.viewbinding.BindableItem

class SuperHeroesRvItem(private val items: SuperHero) : BindableItem<ItemSuperHeroesBinding>() {
    override fun bind(viewBinding: ItemSuperHeroesBinding, position: Int) {
        viewBinding.superHeroName.text = items.name
    }
    override fun getLayout(): Int = R.layout.item_super_heroes

    override fun initializeViewBinding(view: View): ItemSuperHeroesBinding {
        return ItemSuperHeroesBinding.bind(view)
    }

}