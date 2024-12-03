

from flask import Flask, render_template

app = Flask( Maanane )

# Route principale
@app.route('/')
def index():
    return render_template('Portfolio_.html')

if Maanane == 'MaananeZakaria':
    app.run(debug=True)
