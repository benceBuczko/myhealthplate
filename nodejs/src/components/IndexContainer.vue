<template>
<div>
    <div class="container-fluid">
        <div class="row">
            <div class="col carousel">
                <b-carousel id="carousel1"
                            style="text-shadow: 1px 1px 2px #333;"
                            indicators
                            background="#ababab"
                            :interval="4000"
                            img-width="1028"
                            img-height="280"
                            v-model="slide"
                            @sliding-start="onSlideStart"
                            @sliding-end="onSlideEnd"
                >

                    <!-- Text slides with image -->
                    <b-carousel-slide text="Motivation!"
                                        img-src="https://www.genliferegenerativemedicine.com/wp-content/uploads/2016/05/Nutrition-Wellness-Weight-Loss-Miami-1024x280.png"
                    ></b-carousel-slide>

                    <!-- Slides with custom text -->
                    <b-carousel-slide  text="Something Inspirational!"
                                        img-src="http://molinocolombo.it/wp-content/uploads/2016/10/classica-1-1024x280.jpg">
                    </b-carousel-slide>

                    <!-- Slides with image only -->
                    <b-carousel-slide text="Growth Mindset!"
                                        img-src="http://exportimportglobal.com/wp-content/uploads/2017/07/4-5-1024x280.jpg">
                    </b-carousel-slide>
                </b-carousel>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row firstrow">
            <div class="col-lg-6 text-center">
                <img src="http://www.receptdoki.hu/images/cikk_okostanyer.jpg" height="100%" width="90%" />
            </div>
            <div class="col-lg-6 text-center">
                <h2 class="text-center w3-tangerine mainText">Keeping up with a healthy diet is a long-term commitment, but it is within your reach. <br/><br/>
                Register to get started!</h2><br/>
                <b-btn class="btn btn-info text-center registerButton" v-b-modal.modalRegister>Register</b-btn>
            </div>
        </div>
        <br>
        <hr class="featurett-divider">
        <div class="row" id="about">
            <div class="col-lg-6">
                <h2 class="text-center w3-tangerine mainText"> Build a Healthy Eating Style</h2>
                <p>All food and beverage choices matter – focus on variety, amount, and nutrition.
                </p>
                <ul>
                    <li>Use Nutrition Facts labels and ingredient lists to find amounts of saturated fat, sodium, and added sugars in the foods and beverages you choose.</li>
                    <li>Eat the right amount of calories for you based on your age, sex, height, weight, and physical activity level.</li>
                    <li>Building a healthier eating style can help you avoid overweight and obesity and reduce your risk of diseases such as heart disease, diabetes, and cancer.</li>
                </ul>
                <p>Choose an eating style low in saturated fat, sodium, and added sugars.
                </p>
                <ul>
                    <li>Focus on making healthy food and beverage choices from all five food groups including fruits, vegetables, grains, protein foods, and dairy to get the nutrients you need.</li>
                    <li>Look for food and drink choices that are lower in saturated fat, sodium, and added sugar.</li>
                    <li> Eating foods with less sodium can reduce your risk of high blood pressure.</li>
                </ul>
                <p>Make small changes to create a healthier eating style.
                </p>
                <ul>
                    <li>Make half your plate fruits and vegetables.</li>
                    <li>Vary your veggies.</li>
                    <li> Make half your grains whole grains.</li>
                    <li> Move to low-fat and fat-free dairy.</li>
                    <li> Vary your protein routine.</li>
                    <li> Eat and drink the right amount for you.</li>
                </ul>
            </div>
            <div class="col-lg-6 text-center">
                <img class="middle" src="https://images.pexels.com/photos/247685/pexels-photo-247685.png?auto=compress&cs=tinysrgb&h=350">
            </div>
        </div>
        <br>
        <hr class="featurett-divider">
        <div class="row lastrow" id="contact">
            <div class="col-lg-12 text-center">
                <h2 class="text-center w3-tangerine mainText"> Find us here! (But please do not visit...)</h2>
                <p>Nagymező street 44., Budapest - Hungary</p>
                <GoogleMap/>
            </div>
        </div>
        <Register/>
    </div>
    
</div>
</template>

<script>
import Register from '@/components/Register'
import GoogleMap from '@/components/GoogleMap'

export default {
  name: 'IndexContainer',
  components: {Register, GoogleMap},
  data () {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart (slide) {
      this.sliding = true
    },
    onSlideEnd (slide) {
      this.sliding = false
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
  font-size: 300%;
}

li {
  margin-top: 10px;
}
a {
  color: #42b983;
}
.firstrow{
    margin-top: 10%;
}

.registerButton{
    padding-left: 8%;
    padding-right: 8%;
    border-radius: 45%;
}

.w3-tangerine {
    font-family: 'Tangerine', serif;
}

.mainText{
    margin-top: 5%;
}
.container-fluid {
    padding: 0;
}
.container{
    margin-bottom: 50px;
}
.middle{
    margin-top: 150px;
}
.lastrow{
    margin-bottom: 150px!important;
}
</style>
