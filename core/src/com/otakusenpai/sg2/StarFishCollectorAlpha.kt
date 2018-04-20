package com.otakusenpai.sg2

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle

open class StarFishCollectorAlpha : Game() {
    private lateinit var batch: SpriteBatch
    private lateinit var turtleTexture: Texture
    private var turtleX: Float = 0F
    private var turtleY: Float = 0F
    private lateinit var turtleRectangle: Rectangle

    private lateinit var starfishTexture: Texture
    private var starfishX: Float = 0F
    private var starfishY: Float = 0F
    private lateinit var starfishRectangle: Rectangle

    private lateinit var oceanTexture: Texture
    private lateinit var winMsg: Texture

    private var win = false

    override fun create() {
        batch = SpriteBatch()
        turtleTexture = Texture(Gdx.files.internal("turtle-1.png"))
        turtleX = 20F
        turtleY = 20F
        turtleRectangle = Rectangle(turtleX,turtleY,
                turtleTexture.getWidth().toFloat(),turtleTexture.getHeight().toFloat())

        starfishTexture = Texture(Gdx.files.internal("starfish.png"))
        starfishX = 380F
        starfishY = 380F
        starfishRectangle = Rectangle(starfishX,starfishY,
                starfishTexture.getWidth().toFloat(),starfishTexture.getHeight().toFloat())

        oceanTexture = Texture(Gdx.files.internal("water.png"))
        winMsg = Texture(Gdx.files.internal("you-win.png"))
    }

    override fun render() {
        //take input
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            --turtleX
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            ++turtleX
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            ++turtleY
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            --turtleY

        // update position
        turtleRectangle.setPosition(turtleX,turtleY)
        if(turtleRectangle.overlaps(starfishRectangle))
            win = true

        Gdx.gl.glClearColor(0F,0F,0F,1F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        //draw graphics
        batch.begin()
        batch.draw(oceanTexture,0F,0F)
        if(!win)
            batch.draw(starfishTexture,starfishX,starfishY)
        batch.draw(turtleTexture,turtleX,turtleY)
        if(win)
            batch.draw(winMsg,180F,180F)
        batch.end()
    }
}