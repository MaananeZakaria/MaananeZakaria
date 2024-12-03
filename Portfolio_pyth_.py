

from flask import Flask, render_template

app = Flask(__name__)

# Route principale
@app.route('/')
def index():
    return render_template('Portfolio_.html')

if __name__ == '__main__':
    app.run(debug=True)
