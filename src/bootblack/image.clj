(ns bootblack.image)

(defn thumbnail [in out width]
  "Create a thumbnail of the source file. in and out are streams"
  (let [source (javax.imageio.ImageIO/read in)
        old_width (.getWidth source)
        width (min old_width width)
        scale (/ width old_width)
        old_height (.getHeight source)
        height (* scale old_height)
        itype (java.awt.image.BufferedImage/TYPE_INT_ARGB)
        simg (java.awt.image.BufferedImage. width height itype)
        g (.createGraphics simg)]
    (.drawImage g source 0 0 width height nil)
    (.dispose g)
    (javax.imageio.ImageIO/write simg "png" out)))



