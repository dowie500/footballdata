'use strict';
 
module.exports = function(grunt) {
	// Just In Time plugin speeds up grunt
	// Time shows task times for grunt tasks
    require('time-grunt')(grunt);
    require('jit-grunt')(grunt);

    grunt.initConfig({
    	pkg: grunt.file.readJSON('package.json'),
    	include_bootstrap: {
	    	files: {
	    		'': 'less/mainfest.less'
	    	}
	    },
    
	    app: {
	        source: 'src/main/sourceapp',
	        dist: 'src/main/webapp'
	    },

	    clean: {
	        dist: ['.tmp', '<%= app.dist %>/css', '<%= app.dist %>/js', '<%= app.dist %>/img', '<%= app.dist %>/html', '<%= app.dist %>/fonts']
	    },

	    // This allows us to use regular .css file
        copy: {
            css: {
                files: [{
                    expand: true,
                    cwd: 'bower_components/angular-material/',
                    src: 'angular-material.css',
                    //dest: '.tmp/scss/',
                    dest: '<%= app.dist %>/css',
                    rename: function(dest, src) {
                        return dest + "_" + src.substring(0, src.indexOf('.')) + '.scss';
                    }
                },{
                    expand: true,
                    cwd: 'bower_components/bootstrap/dist/css',
                    src: 'bootstrap.min.css',
                    //dest: '.tmp/scss/',
                    dest: '<%= app.dist %>/css',
                    rename: function(dest, src) {
                        return dest + "_" + src.substring(0, src.indexOf('.')) + '.scss';
                    }
                }]
            }
        },

//        sass: {
//	        options: {
//	            includePaths: [
//	                'bower_components/bootstrap-sass/assets/stylesheets',
//	                '.tmp/scss'
//	            ]
//	        },
// Currently don't need this as not deploying to server
//	        server: {
//	            options: {
//	                sourceMap: true
//	            },
//	            files: [{
//	                expand: true,
//	                cwd: '<%= app.source %>/scss',
//	                src: '**/*.{scss,sass}',
//	                dest: '.tmp/css',
//	                ext: '.css'
//	            }]
//	        },
//	        dist: {
//	            options: {
//	                outputStyle: 'compressed'
//	            },
//	            files: [{
//	                expand: true,
//	                cwd: '<%= app.source %>/scss',
//	                src: '**/*.{scss,sass}',
//	                dest: '.tmp/css',
//	                ext: '.css'
//	            }]
//	        }
//	    },
	    autoprefixer: {
	        options: {
	            browsers: ['last 3 versions']
	        },
	        dist: {
	            files: [{
	                expand: true,
	                cwd: '.tmp/css',
	                src: '**/*.css',
	                dest: '<%= app.dist %>/css'
	            }]
	        }
	    },

	    uglify: {
//            server: {
//                options: {
//                    mangle: false,
//                    beautify: true
//                },
//                files: {
//                    '<%= app.dist %>/js/scripts.js': [
//                        'bower_components/jquery/dist/jquery.js',
//                        'bower_components/angular/angular.js',
//                        'bower_components/angular-resource/angular-resource.js',
//                        'bower_components/angular-route/angular-route.js',
//                        'bower_components/angular-animate/angular-animate.js',
//                        'bower_components/angular-material/angular-material.js',
//                        'bower_components/angular-translate/angular-translate.js'
//                        ],
// 
//                        '<%= app.dist %>/js/app.js': [
//                        '<%= app.source %>/js/app.js',
//                        '<%= app.source %>/js/controllers.js'
//                    ]
//                }
//            },
            dist: {
                options: {
                    compress: true,
                    preserveComments: false,
                    report: 'min'
                },
                files: {
                    '<%= app.dist %>/js/scripts.js': [
                        'bower_components/jquery/dist/jquery.js',
                        'bower_components/angular/angular.js',
                        'bower_components/angular-resource/angular-resource.js',
                        'bower_components/angular-route/angular-route.js',
                        'bower_components/angular-animate/angular-animate.js',
                        'bower_components/angular-material/angular-material.js',
                        'bower_components/angular-translate/angular-translate.js'
                        ],
 
                        '<%= app.dist %>/js/app.js': [
                        //'<%= app.source %>/js/app.js',
                        //'<%= app.source %>/js/controllers.js'
                    ]
                }
            }
        }
    })
    // Then our actual grunt runner tasks
    // Currently missing a task to 'serve'
//    grunt.registerTask('build', ['clean', 'copy:css', 'sass:dist',
//        'autoprefixer', 'uglify:dist'
//    ]);

    // Can't see why we need sass yet so commented out above and removed here
    grunt.registerTask('build', ['clean', 'copy:css',
        'autoprefixer', 'uglify:dist'
    ]);
 
    grunt.registerTask('default', ['build']);
    
}