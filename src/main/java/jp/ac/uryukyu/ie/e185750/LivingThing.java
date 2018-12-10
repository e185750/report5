package jp.ac.uryukyu.ie.e185750;

/**
 * 勇者とモンスターのバトルの実装
 *   String name; //ヒーローと敵の名前
 *   int hitPoint; //ヒーローと敵のHP
 *   int attack; //ヒーローと敵の攻撃力
 *   boolean dead; //敵の生死状態。true=死亡。
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     *
     * @return
     */

    public boolean getDead(){
        return dead;
    }

    /**
     *
     * @param dead　敵の生死状態
     */

    public void  setDead(boolean dead){
        this.dead = dead;
    }

    /**
     *
     * @return
     */

    public int getHitPoint(){
        return  hitPoint;
    }

    /**
     *
     * @param hitPoint　ヒーローと敵のHP
     */

    public void  setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     *　コンストラクタ。名前、最大HP、攻撃力を指定する。
     *　ヒーローと敵の名前とHPと攻撃力を出力している。
     *
     * @param name　　　　ヒーローと敵の名前　　　　
     * @param maximumHP　ヒーローと敵のHP
     * @param attack　　　ヒーローと敵の攻撃力
     */
    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     *
     * @return dead
     */

    public boolean isDead(){return dead;}

    /**
     *
     * @return name
     */

    public String getName(){return name;}

    /**
     *
     * @param opponent　
     */

    public void attack(LivingThing opponent){
        int damage = (int) (Math.random() * attack);
        if(dead == false) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }

    }

    /**
     *
     * @param damage　受けたダメージ
     */

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
