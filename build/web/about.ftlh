<!DOCTYPE html>
<html>
    <head>
        <title>AboutUs</title>

        <link rel="stylesheet" type="text/css" href="aboutUscss.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    
    <body>

    <div id="container">
        <div class="container-fluid">
          <h1>About Us</h1>
            <br>      
            <p style="background-color:transparent;padding:20px;">

The brain uses a number of automatic mechanisms to determine what information to retain. Everything else naturally fades away.

The brain's overriding principle, given to it from millions of years of evolution, is to retain whatever is likely to be useful later for long-term survival. Since the future utility of information is impossible to predict, the brain uses a number of heuristics that have been honed over the millenia.


</p>
        </div>
        <br>
        <label for="name">Contact Us</label>
    <div class="row">
        <div class="col-md-8">
            <div class="well well-sm">
                <form>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Name</label>
                            <input type="text" class="form-control" id="name" placeholder="Enter name" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Email Address</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="Enter email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Subject</label>
                            <select id="subject" name="subject" class="form-control" required="required">
                                <option value="na" selected="">Choose One:</option>
                                <option value="service">General Customer Service</option>
                                <option value="suggestions">Suggestions</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Message</label>
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Message"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <form>
            <legend><span class="glyphicon glyphicon-globe"></span>Our office</legend>
            <address>
                <strong>D!V@</strong><br>
                45 Folsom Ave, Suite 600<br>
                Iasi, RO 700605<br>
                <abbr title="Phone">
                    P:</abbr>
                +4075486438
            </address>
            <address>
                <strong>Full Name</strong><br>
                <a href="mailto:#">lastperfectteam@example.com</a>
            </address>
            </form>
        </div>
    </div>
</div>


    </div>



</body>
</html>