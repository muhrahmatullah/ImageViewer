package com.rahmat.app.imgevwer.features.image

import com.rahmat.app.imgevwer.entity.Image
import com.rahmat.app.imgevwer.features.base.BasePresenter

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class ImagePresenter: BasePresenter<ImageContract.View>(), ImageContract.Presenter {

    var list: MutableList<Image> = mutableListOf()

    override fun initImage() {
        var image = Image("https://www.thesprucepets.com/thmb/7kVrWdBf13osb9nYJ-4D2yPAwfQ=/425x326/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-466792657-59cef0d6c412440010be728c.jpg", "The Black Cat")
        list.add(image)
        image = Image("http://ichef.bbci.co.uk/wwfeatures/wm/live/624_351/images/live/p0/6f/l7/p06fl7vh.jpg", "The Dimming Cat")
        list.add(image)
        image = Image("https://d32xvgr96w2oxp.cloudfront.net/2018/02/races-chat-populaire-chartreux.jpg", "The Grey Cat")
        list.add(image)
        image = Image("https://static.toiimg.com/img/60828043/Master.jpg", "The Starring Cat")
        list.add(image)
        image = Image("https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fpeopledotcom.files.wordpress.com%2F2017%2F11%2Fno-nose-nigel-5.jpg%3Fw%3D1080&w=700&q=85", "The Toothless Cat")
        list.add(image)
        image = Image("https://s.hswstatic.com/gif/whiskers-sam.jpg", "The Handsome Cat")
        list.add(image)
        mView?.showImage(list)
    }
}