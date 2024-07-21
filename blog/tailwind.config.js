/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
      "./src/**/*.{js,jsx,ts,tsx}",
    ],
    darkMode: 'class',
    theme: {
        container: {
            center: true
        },
        extend: {
            colors: {
                "hamitmizrak-red": "red",
                "hamitmizrak-blue": "blue",
                "hamitmizrak-yellow": "yellow",
                "hamitmizrak-gray": "#f2f2f2",
                "hamitmizrak-antrasit": "#383E42",
                "hamitmizrak-white": "#ffffff",
                primary: {"50":"#eff6ff","100":"#dbeafe","200":"#bfdbfe","300":"#93c5fd","400":"#60a5fa","500":"#3b82f6","600":"#2563eb","700":"#1d4ed8","800":"#1e40af","900":"#1e3a8a","950":"#172554"}
            },
            fontFamily: {
                font: ['Montserrat', 'sans-serif'],
                open: ['Open Sans', 'sans-serif'],
            }
        },
    },
    plugins: [],
}


